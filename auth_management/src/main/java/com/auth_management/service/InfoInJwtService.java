package com.auth_management.service;

import com.common.model.ManagerClaim;

public interface InfoInJwtService {

    ManagerClaim getPayload(String jwt);

}
