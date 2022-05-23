package com.admin_management.service;

import com.admin_management.model.entity.Account;
import com.common.model.bo.AccountStatus;

public interface AccountInternalService {

    Account findByIdAndStatus(String accountId, AccountStatus status, String message);

    void deleteAccount(String id);

    Account findByIdAndStatus(String id , AccountStatus accountStatus);
}
