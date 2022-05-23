package com.admin_management.service.impl;

import com.admin_management.service.InfoInJwtService;
import com.admin_management.util.Global;
import com.common.model.AccountClaim;
import com.common.util.Json;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class InfoInJwt implements InfoInJwtService {

    /**
     * Get Payload in JWT
     *
     * param jwt
     * @return AccountClaim
     */
    public AccountClaim getPayload(String jwt) {
        if (StringUtils.isEmpty(jwt)) return null;

        String payload = jwt.split("\\.")[1];

        payload = new String(Base64.getDecoder().decode(payload));
        return Json.decode(payload.getBytes(StandardCharsets.UTF_8), Global.driveClaimReader);
    }

}
