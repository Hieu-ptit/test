package com.permission.service;

import com.permission.model.entity.Role;

import java.util.List;

public interface RoleInternalService {
    List<Role> findByAccountId(String accountId);

}
