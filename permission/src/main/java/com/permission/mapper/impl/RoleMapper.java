package com.permission.mapper.impl;

import com.permission.model.entity.Role;
import com.permission.model.request.RoleRequest;
import com.permission.model.response.GetRoleResponse;
import com.permission.model.response.RoleResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    public Role map(RoleRequest request, Map<String, Integer> bitSetModule) {
        return new Role().setName(request.getName())
                .setDescription(request.getDescription())
                .setBitSetModule(bitSetModule);
    }

    public Role map(Role role, RoleRequest roleRequest, Map<String, Integer> bitSetModule) {
        return role.setName(roleRequest.getName())
                .setDescription(roleRequest.getDescription())
                .setBitSetModule(bitSetModule);
    }

    public GetRoleResponse mapRole(Role role) {
        return new GetRoleResponse()
                .setId(role.getId())
                .setName(role.getName())
                .setDescription(role.getDescription());
    }

    public List<GetRoleResponse> map(List<Role> roleList) {
        return roleList.stream().map(this::mapRole).collect(Collectors.toList());
    }

    public RoleResponse mapResponse(Role role) {
        return new RoleResponse()
                .setId(role.getId())
                .setName(role.getName())
                .setBitSetModule(role.getBitSetModule());
    }

    public List<RoleResponse> mapResponses(List<Role> roles) {
        return roles.stream().map(this::mapResponse).collect(Collectors.toList());
    }

}
