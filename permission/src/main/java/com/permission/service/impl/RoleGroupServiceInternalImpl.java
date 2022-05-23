package com.permission.service.impl;

import com.permission.model.entity.RoleGroup;
import com.permission.repository.RoleGroupRepository;
import com.permission.service.RoleGroupServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleGroupServiceInternalImpl implements RoleGroupServiceInternal {

    private final RoleGroupRepository repository;

    public void insertAll(List<RoleGroup> roleGroups) {
        repository.insertAll(roleGroups);
    }

    @Override
    public void deleteAllByRoleId(int roleId) {
        repository.deleteAllByRoleId(roleId);
    }
}
