package com.permission.service;

import com.permission.model.entity.RoleFeature;

import java.util.List;
import java.util.Set;

public interface RoleFeatureServiceInternal {

    List<RoleFeature> getByRoleId(int roleId);

    List<RoleFeature> getByRoleIds(Set<Integer> roleId);

    void insertAll(List<RoleFeature> roleFeatures);

    void deleteAllByRoleId(int roleId);

}
