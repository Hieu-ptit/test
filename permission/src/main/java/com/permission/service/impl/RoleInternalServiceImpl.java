package com.permission.service.impl;

import com.permission.model.entity.Role;
import com.permission.repository.RoleRepository;
import com.permission.service.RoleInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleInternalServiceImpl implements RoleInternalService {

    private final RoleRepository repository;

    /**
     * get role account
     *
     * @param accountId accountId
     * @return List<Role>
     */
    @Override
    public List<Role> findByAccountId(String accountId) {
        return repository.findByAccountId(accountId);
    }
}
