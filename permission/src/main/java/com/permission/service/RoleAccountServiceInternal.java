package com.permission.service;

import com.permission.model.entity.RoleAccount;

import java.util.List;

public interface RoleAccountServiceInternal {

    List<RoleAccount> getAllByAccountId(String accountId);

    Boolean existsByRoleId(int roleId);
}
