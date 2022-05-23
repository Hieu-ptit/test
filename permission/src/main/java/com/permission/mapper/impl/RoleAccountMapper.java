package com.permission.mapper.impl;

import com.permission.model.entity.RoleAccount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleAccountMapper {

    public List<RoleAccount> mapList(Set<Integer> roleIds, String accountId) {
        return roleIds.stream().map(i -> map(i, accountId)).collect(Collectors.toList());
    }

    private RoleAccount map(Integer roleId, String accountId) {
        RoleAccount roleAccount = new RoleAccount();
        roleAccount.setAccountId(accountId).setRoleId(roleId);
        return roleAccount;
    }

}
