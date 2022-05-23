package com.permission.service.impl;

import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import com.permission.config.PermissionData;
import com.permission.mapper.impl.RoleMapper;
import com.permission.model.entity.*;
import com.permission.model.request.AuthorRequest;
import com.permission.model.request.RoleRequest;
import com.permission.model.request.ValidateRolesRequest;
import com.permission.model.response.GetRoleResponse;
import com.permission.model.response.RoleResponseDetail;
import com.permission.repository.RoleRepository;
import com.permission.service.RoleAccountServiceInternal;
import com.permission.service.RoleFeatureServiceInternal;
import com.permission.service.RoleGroupServiceInternal;
import com.permission.service.RoleService;
import com.permission.validator.RoleValidator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final PermissionData permissionData;
    private final RoleRepository repository;
    private final RoleMapper roleMapper;
    private final RoleValidator validator;
    private final RoleFeatureServiceInternal roleFeatureServiceInternal;
    private final RoleGroupServiceInternal roleGroupServiceInternal;
    private final RoleAccountServiceInternal roleAccountServiceInternal;

    @Override
    public List<GetRoleResponse> findAll() {

        var roleList = repository.findByOrderByCreatedAtDesc();

        return roleMapper.map(roleList);
    }

    @Override
    public RoleResponseDetail getRoleByAccountId(String accountId) {

        List<Role> roles = repository.findByAccountId(accountId);

        if (roles.isEmpty()) return new RoleResponseDetail().setRoleResponses(new ArrayList<>());

        return new RoleResponseDetail()
                .setRoleResponses(roleMapper.mapResponses(roles));
    }

    /**
     * Get Action by Account Id
     *
     * @param accountId accountId
     * @return Set<String>
     */
    public Set<String> getActions(String accountId) {

        List<RoleAccount> roleAccounts = roleAccountServiceInternal.getAllByAccountId(accountId);

        Set<Integer> roleIds = roleAccounts.stream()
                .map(RoleAccount::getRoleId)
                .collect(Collectors.toSet());

        List<RoleFeature> roleFeatures = roleFeatureServiceInternal.getByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleFeatures))
            throw new BusinessException(ErrorCode.UNAUTHORIZED, ErrorCode.UNAUTHORIZED.getMessage());

        return roleFeatures.stream()
                .map(it -> permissionData.idNFeatureMap.get(it.getFeatureId()).getActionCode())
                .filter(it -> !StringUtils.isBlank(it))
                .collect(Collectors.toSet());
    }

    /**
     * Create Role
     *
     * @param roleRequest roleRequest
     * @return Boolean
     */
    @Override
    @Transactional
    public Boolean create(RoleRequest roleRequest) {

        validator.validate(roleRequest.getName());

        insertRole(null, roleRequest);

        return true;
    }

    /**
     * Update Role
     *
     * @param roleId      roleId
     * @param roleRequest roleRequest
     * @return Boolean
     */
    @Override
    @Transactional
    public Boolean update(Integer roleId, RoleRequest roleRequest) {

        validator.validate(roleRequest.getName(), roleId);

        roleFeatureServiceInternal.deleteAllByRoleId(roleId);

        roleGroupServiceInternal.deleteAllByRoleId(roleId);

        insertRole(roleId, roleRequest);

        return true;
    }


    @Override
    public Boolean validate(ValidateRolesRequest validateRolesRequest) {
        var roles = repository.findByIdIn(validateRolesRequest.getRoleIds());

        if (CollectionUtils.isEmpty(roles)) return false;

        if (roles.size() != validateRolesRequest.getRoleIds().size())
            throw new BusinessException(ErrorCode.GROUP_PERMISSION_INVALID,
                    String.format(ErrorMessage.GROUP_PERMISSION_INVALID, validateRolesRequest.getRoleIds().toString()));

        return true;
    }

    /**
     * Authorization
     *
     * @param authorRequest authorRequest
     * @return boolean
     */
    @Override
    public boolean authorization(AuthorRequest authorRequest) {
        Feature feature = permissionData.findFeatureByPathNMethod(authorRequest.getPath(), authorRequest.getMethod());
        if (feature == null) return false;

        Map<Integer, Map<String, Integer>> bitSetModule = authorRequest.getBitSetModule();
        for (Integer roleId : bitSetModule.keySet()) {
            Integer totalPoint = bitSetModule.get(roleId).get(permissionData.idFeatureNIdGroupMap.get(feature.getId()));
            if (totalPoint != null)
                if ((totalPoint & feature.getPoint()) > 0)
                    return true;
        }

        return false;
    }

    /**
     * Calculator for bit set module
     *
     * @param groupFeature groupFeature
     * @return Map<String, Integer>
     */
    private Map<String, Integer> calculatorPointToBitSetModule(Map<String, Set<Integer>> groupFeature) {
        Map<String, Integer> bitSetModule = new HashMap<>();

        groupFeature.keySet().forEach(groupId -> {
            Set<Integer> featureIdSet = groupFeature.get(groupId);
            Integer totalPointInGroup = featureIdSet.stream()
                    .mapToInt(featureId -> permissionData.idNFeatureMap.get(featureId).getPoint()).sum();

            bitSetModule.put(groupId, totalPointInGroup);
        });

        return bitSetModule;
    }

    /**
     * Delete a role r if exists in database
     * <pre> if r is being used by an account
     *          throw exception <b>ROLE_IS_INDELIBLE</b>
     *       if r does not exist
     *          throw exception <b>ROLE_DOES_NOT_EXIST</b>
     *       else
     *          delete r in database
     * </pre>
     *
     * @param roleId int
     * @return boolean
     */
    @Override
    public Boolean delete(int roleId) {

        if (roleAccountServiceInternal.existsByRoleId(roleId))
            throw new BusinessException(ErrorCode.ROLE_IS_INDELIBLE, null);

        if (!repository.existsById(roleId))
            throw new BusinessException(ErrorCode.ROLE_DOES_NOT_EXIST, null);

        roleFeatureServiceInternal.deleteAllByRoleId(roleId);

        roleGroupServiceInternal.deleteAllByRoleId(roleId);

        repository.deleteById(roleId);

        return true;
    }

    /**
     * insert role
     *
     * @param roleRequest roleRequest
     */
    private void insertRole(Integer roleId, RoleRequest roleRequest) {
        Role role;

        Map<String, Set<Integer>> groupFeature = roleRequest.getGroupFeature();

        Set<String> groupIds = groupFeature.keySet().stream()
                .filter(it -> !CollectionUtils.isEmpty(groupFeature.get(it)))
                .collect(Collectors.toSet());

        Set<Integer> featureIds = getFeature(groupFeature);

        validator.validate(groupFeature, groupIds, featureIds);

        if (roleId == null) {

            role = roleMapper.map(roleRequest, calculatorPointToBitSetModule(groupFeature));

            role = repository.insert(role);
        } else {

            role = repository.findById(roleId)
                    .orElseThrow(() -> new BusinessException(ErrorCode.ROLE_DOES_NOT_EXIST, "ROLE DOES NOT EXIST"));

            role = roleMapper.map(role, roleRequest, calculatorPointToBitSetModule(groupFeature));

            role = repository.update(role);
        }

        // save role-group
        roleGroupServiceInternal.insertAll(getRoleGroup(groupIds, role.getId()));

        roleFeatureServiceInternal.insertAll(getRoleFeature(featureIds, role.getId()));
    }

    private List<RoleGroup> getRoleGroup(Set<String> groupIds, Integer roleId) {
        if (roleId == null) return new ArrayList<>();
        return groupIds.stream()
                .map(it -> new RoleGroup().setGroupId(it).setRoleId(roleId))
                .collect(Collectors.toList());
    }

    private List<RoleFeature> getRoleFeature(Set<Integer> featureIds, Integer roleId) {
        if (roleId == null) return new ArrayList<>();
        return featureIds.stream()
                .map(it -> new RoleFeature().setFeatureId(it).setRoleId(roleId))
                .collect(Collectors.toList());
    }

    private Set<Integer> getFeature(Map<String, Set<Integer>> groupFeature) {
        Set<Integer> featureIds = new HashSet<>();
        groupFeature.values().forEach(featureIds::addAll);
        return featureIds;
    }


}
