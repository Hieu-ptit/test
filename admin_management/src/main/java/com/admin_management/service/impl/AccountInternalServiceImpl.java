package com.admin_management.service.impl;

import com.admin_management.model.entity.Account;
import com.admin_management.repository.AccountRepository;
import com.admin_management.service.AccountInternalService;
import com.common.exception.BusinessException;
import com.common.model.bo.AccountStatus;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountInternalServiceImpl implements AccountInternalService {

    private final AccountRepository repository;

    /**
     * Find Account by ID and Status
     *
     * @param accountId accountId
     * @return Account
     */
    public Account findByIdAndStatus(String accountId, AccountStatus status, String message) {
        return repository.findByIdAndStatus(accountId, status)
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.ACCOUNT_NOT_FOUND,
                                String.format(message, accountId)));
    }

    /**
     * Find Account by ID and Status
     *
     * @param username username
     * @return Account
     */
    public Account findByUsernameAndStatus(String username, AccountStatus status, String message) {
        return repository.findByUsernameAndStatus(username, status)
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.ACCOUNT_NOT_FOUND,
                                String.format(message, username)));
    }

    /**
     * delete account by id
     *
     * @param id id
     */
    @Override
    public void deleteAccount(String id) {

        repository.deleteAccount(id);

    }

    @Override
    public Account findByIdAndStatus(String id, AccountStatus accountStatus) {

        return repository.findByIdAndStatusNot(id, accountStatus)
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.ACCOUNT_NOT_FOUND,
                                ErrorMessage.ACCOUNT_NOT_FOUND_OR_DELETE));
    }
}

