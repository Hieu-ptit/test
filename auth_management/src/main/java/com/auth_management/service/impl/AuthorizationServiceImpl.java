package com.auth_management.service.impl;

import com.auth_management.service.AuthorizationService;
import com.common.model.API;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    public static final API[] apiDriver = new API[]{
            API.with("^/accounts/login$")
    };

    private final String uriCoreDriver;
    private final String uriCoreEnterprise;

    public AuthorizationServiceImpl(@Value("${app.base.url.management.admin}") String uriCoreDriver,
                                    @Value("${app.base.url.enterprise}") String uriCoreEnterprise) {
        this.uriCoreDriver = uriCoreDriver;
        this.uriCoreEnterprise = uriCoreEnterprise;
    }





}
