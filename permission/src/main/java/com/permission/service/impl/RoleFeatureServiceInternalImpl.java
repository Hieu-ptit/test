package com.permission.service.impl;

import com.permission.model.entity.RoleFeature;
import com.permission.repository.RoleFeatureRepository;
import com.permission.service.RoleFeatureServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleFeatureServiceInternalImpl implements RoleFeatureServiceInternal {

    private final RoleFeatureRepository repository;

    /**
     * get all by account id
     *
     * @param roleId roleId
     * @return List<RoleFeature>
     */
    @Override
    public List<RoleFeature> getByRoleId(int roleId) {
        return repository.findByRoleId(roleId);
    }

    @Override
    public List<RoleFeature> getByRoleIds(Set<Integer> roleId) {
        return repository.findByRoleIdIn(roleId);
    }

    /**
     * insert all role features
     *
     * @param roleFeatures roleFeatures
     */
    public void insertAll(List<RoleFeature> roleFeatures) {
        repository.insertAll(roleFeatures);
    }

    @Override
    public void deleteAllByRoleId(int roleId) {
        repository.deleteAllByRoleId(roleId);
    }

}
