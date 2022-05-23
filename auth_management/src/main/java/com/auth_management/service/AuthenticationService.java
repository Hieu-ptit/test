package com.auth_management.service;

import com.auth_management.model.request.ChangePasswordLoginFirstTimes;
import com.common.model.response.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CompletableFuture;

public interface AuthenticationService {
    CompletableFuture<Response<?>> registerOrLogin(HttpServletRequest request, HttpServletResponse servletResponse);

    void logout(HttpServletRequest request);

    CompletableFuture<Response<?>> changePasswordInLoginFirstTime(ChangePasswordLoginFirstTimes request, HttpServletResponse servletResponse);
}
