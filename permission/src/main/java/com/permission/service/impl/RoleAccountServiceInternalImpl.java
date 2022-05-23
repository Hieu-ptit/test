package com.permission.service.impl;

import com.permission.model.entity.RoleAccount;
import com.permission.repository.RoleAccountRepository;
import com.permission.service.RoleAccountServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleAccountServiceInternalImpl implements RoleAccountServiceInternal {

    private final RoleAccountRepository repository;

    /**
     * get all by account id
     *
     * @param accountId accountId
     * @return List<RoleAccount>
     */
    @Override
    public List<RoleAccount> getAllByAccountId(String accountId) {
        return repository.findByAccountId(accountId);
    }

    /**
     * check exists by role id
     *
     * @param roleId roleId
     * @return Boolean
     */
    @Override
    public Boolean existsByRoleId(int roleId) {
        return repository.existsByRoleId(roleId);
    }
}
