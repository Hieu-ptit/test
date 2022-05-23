package com.permission.service;

import com.permission.model.request.CreateRoleAccountRequest;
import com.permission.model.request.UpdateRoleAccountRequest;

public interface RoleAccountService {

    Boolean create(CreateRoleAccountRequest createRequest);

    Boolean update(UpdateRoleAccountRequest updateRoleAccountRequest);

}
