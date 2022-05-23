package com.admin_management.service;

import com.common.model.AccountClaim;

public interface InfoInJwtService {

    AccountClaim getPayload(String jwt);

}
