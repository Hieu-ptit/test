package com.permission.service;

import com.permission.model.request.AuthorRequest;
import com.permission.model.request.RoleRequest;
import com.permission.model.request.ValidateRolesRequest;
import com.permission.model.response.GetRoleResponse;
import com.permission.model.response.RoleResponseDetail;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<GetRoleResponse> findAll();

    RoleResponseDetail getRoleByAccountId(String accountId);

    Set<String> getActions(String accountId);

    Boolean create(RoleRequest roleRequest);

    Boolean update(Integer roleId, RoleRequest roleRequest);

    Boolean validate(ValidateRolesRequest validateRolesRequest);

    boolean authorization(AuthorRequest authorRequest);

    Boolean delete(int roleId);

}
