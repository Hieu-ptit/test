package com.auth_management.service.impl;

import com.auth_management.service.InfoInJwtService;
import com.auth_management.util.Global;
import com.common.model.ManagerClaim;
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
     * @param jwt
     * @return
     */
    public ManagerClaim getPayload(String jwt) {
        if (StringUtils.isEmpty(jwt)) return null;

        String payload = jwt.split("\\.")[1];

        payload = new String(Base64.getDecoder().decode(payload));

        return Json.decode(payload.getBytes(StandardCharsets.UTF_8), Global.managerClaimReader);
    }

}
