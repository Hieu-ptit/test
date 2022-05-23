package com.permission.service.impl;

import com.permission.config.PermissionData;
import com.permission.mapper.ModuleMapper;
import com.permission.model.entity.Feature;
import com.permission.model.entity.Group;
import com.permission.model.entity.Module;
import com.permission.model.entity.RoleFeature;
import com.permission.model.response.ModuleResponse;
import com.permission.repository.ModuleRepository;
import com.permission.service.ModuleService;
import com.permission.service.RoleFeatureServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleMapper mapper;
    private final ModuleRepository repository;
    private final PermissionData permissionData;
    private final RoleFeatureServiceInternal roleFeatureRepository;

    /**
     * get all module detail.
     *
     * @return List<ModuleResponse>
     */
    @Override
    public List<ModuleResponse> getAll() {
        return getAllModuleResponse(new ArrayList<>());
    }

    /**
     * get all by id account
     *
     * @param roleId roleId
     * @return List<ModuleResponse>
     */
    @Override
    public List<ModuleResponse> getByRoleId(int roleId) {

        List<RoleFeature> roleFeatures = roleFeatureRepository.getByRoleId(roleId);

        List<Integer> featureIds = roleFeatures.stream().map(RoleFeature::getFeatureId).collect(Collectors.toList());

        return getAllModuleResponse(featureIds);

    }

    private List<ModuleResponse> getAllModuleResponse(List<Integer> featureIds) {
        List<Module> modules = repository.findAll();

        if (CollectionUtils.isEmpty(modules)) return new ArrayList<>();

        List<Group> groups = permissionData.groups;

        Map<String, List<Feature>> groupFeatureMap = permissionData.groupFeatureMap;

        return mapper.map(modules, groups, groupFeatureMap, featureIds);
    }

}
