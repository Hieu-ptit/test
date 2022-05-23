package com.permission.service;

import com.permission.model.entity.RoleGroup;

import java.util.List;

public interface RoleGroupServiceInternal {

    void insertAll(List<RoleGroup> roleGroups);

    void deleteAllByRoleId(int roleId);

}
