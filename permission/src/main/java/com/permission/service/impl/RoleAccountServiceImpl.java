package com.permission.service.impl;

import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import com.permission.mapper.impl.RoleAccountMapper;
import com.permission.model.entity.RoleAccount;
import com.permission.model.request.CreateRoleAccountRequest;
import com.permission.model.request.UpdateRoleAccountRequest;
import com.permission.repository.RoleAccountRepository;
import com.permission.repository.RoleRepository;
import com.permission.service.RoleAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleAccountServiceImpl implements RoleAccountService {

    private final RoleAccountRepository repository;
    private final RoleRepository roleRepository;
    private final RoleAccountMapper mapper;

    /**
     * create role account
     *
     * @param createRequest createRequest
     * @return Boolean
     */
    @Override
    public Boolean create(CreateRoleAccountRequest createRequest) {
        return createRoleAccount(createRequest.getAccountId(), createRequest.getRoleIds());
    }

    /**
     * update role account by account id
     *
     * @param updateRequest updateRequest
     * @return Boolean
     */
    @Override
    public Boolean update(UpdateRoleAccountRequest updateRequest) {

        repository.deleteByAccountId(updateRequest.getAccountId());

        return createRoleAccount(updateRequest.getAccountId(), updateRequest.getRoleIds());
    }

    /**
     * create role account
     *
     * @param accountId accountId
     * @param roleIds roleIds
     * @return Boolean
     */
    private Boolean createRoleAccount(String accountId, Set<Integer> roleIds) {
        boolean isExistAccount = repository.existsByAccountId(accountId);
        if (isExistAccount)
            throw new BusinessException(ErrorCode.ACCOUNT_ROLE_IS_EXISTED, ErrorMessage.ACCOUNT_ROLE_IS_EXISTED);

        var roles = roleRepository.findByIdIn(roleIds);
        if (roles.size() != roleIds.size())
            throw new BusinessException(ErrorCode.GROUP_PERMISSION_INVALID,
                    String.format(ErrorMessage.GROUP_PERMISSION_INVALID, roleIds.toString()));

        List<RoleAccount> list = mapper
                .mapList(roleIds, accountId);

        repository.saveAll(list);
        return true;
    }
}
