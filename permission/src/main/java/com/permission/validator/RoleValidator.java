package com.permission.validator;

import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.permission.config.PermissionData;
import com.permission.model.entity.Feature;
import com.permission.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleValidator {

    private final PermissionData permissionData;
    private final RoleRepository repository;

    /**
     * Validate for creating role
     *
     * @param groupFeature groupFeature
     * @param groupIds groupIds
     * @param featureIds featureIds
     */
    public void validate(Map<String, Set<Integer>> groupFeature, Set<String> groupIds, Set<Integer> featureIds) {

        haveGroupId(groupIds);
        haveFeatureId(featureIds);

        groupIds.forEach(it -> {
            List<Feature> features = permissionData.groupFeatureMap.get(it);

            List<Integer> featureIdSystems = features.stream()
                    .filter(Objects::nonNull)
                    .map(Feature::getId)
                    .collect(Collectors.toList());

            boolean valid = featureIdSystems.containsAll(groupFeature.get(it));
            if (!valid)
                throw new BusinessException(ErrorCode.GROUP_NOT_CONTAIN_THIS_FEATURE, "GROUP NOT CONTAIN THIS FEATURE");
        });
    }

    private void haveGroupId(Set<String> groupIds) {
        groupIds.forEach(it -> {
            if (!permissionData.idNGroupMap.containsKey(it))
                throw new BusinessException(ErrorCode.GROUP_ID_INVALID, "GROUP ID INVALID " + it);
        });
    }

    private void haveFeatureId(Set<Integer> featureIds) {
        featureIds.forEach(it -> {
            if (!permissionData.idNFeatureMap.containsKey(it))
                throw new BusinessException(ErrorCode.FEATURE_ID_INVALID, "FEATURE ID INVALID " + it);
        });
    }

    public void validate(String name) {
        if (repository.existsByName(name))
            throw new BusinessException(ErrorCode.ROLE_NAME_IS_EXIST, "ROLE IS EXIST " + name);
    }

    public void validate(String name, Integer roleId) {
        if (repository.existsByNameAndIdNot(name, roleId))
            throw new BusinessException(ErrorCode.ROLE_NAME_IS_EXIST, "ROLE IS EXIST " + name);
    }


}
