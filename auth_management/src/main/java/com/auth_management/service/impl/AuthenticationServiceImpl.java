package com.auth_management.service.impl;

import com.auth_management.caller.PermissionCaller;
import com.auth_management.caller.RestClient;
import com.auth_management.model.request.ChangePasswordLoginFirstTimes;
import com.auth_management.model.response.LoginResponse;
import com.auth_management.model.response.AccountAuth;
import com.auth_management.security.BOSessionManager;
import com.auth_management.security.JwtProvider;
import com.auth_management.security.LoginSessionManager;
import com.auth_management.service.AuthenticationService;
import com.auth_management.service.ProxyService;
import com.auth_management.util.Global;
import com.common.exception.BusinessException;
import com.common.model.AccountClaim;
import com.common.model.bo.AccountStatus;
import com.common.model.response.Response;
import com.common.util.Constant;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import com.common.util.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final ApiDistribute apiDistribute;
    private final JwtProvider jwtProvider;
    private final ProxyService proxyService;
    private final LoginSessionManager loginSessionManager;
    private final BOSessionManager boSessionManager;
    private final RestClient restClient;
    private final PermissionCaller permissionCaller;

    /**
     * Register or Login (forward)
     *
     * @param request
     * @param servletResponse
     * @return
     */
    @Override
    public CompletableFuture<Response<?>> registerOrLogin(HttpServletRequest request, HttpServletResponse servletResponse) {
        return proxyService.forwardRequest(request).thenApply(httpResponse -> auth(servletResponse, httpResponse));
    }

    /**
     * Logout
     *
     * @param request
     */
    @Override
    public void logout(HttpServletRequest request) {
        AccountClaim accountClaim = jwtProvider.getAccountClaim(request);

        if (!loginSessionManager.revokeLoginSession(accountClaim.getAccountId()))
            throw new BusinessException
                    (ErrorCode.INTERNAL_BUFFER_ERROR, String.format(ErrorMessage.CAN_NOT_DELETE_SESSION, accountClaim.getAccountId()));

    }


    /**
     * Change password when login first times
     *
     * @param request
     * @return
     */
    @Override
    public CompletableFuture<Response<?>> changePasswordInLoginFirstTime(ChangePasswordLoginFirstTimes request,
                                                                         HttpServletResponse servletResponse) {
        boolean valid = boSessionManager.verifySessionCode(request.getId(), Constant.SS_FIRST_TIMES);
        if (!valid)
            throw new BusinessException(ErrorCode.NOT_ENOUGH_CONDITION_FOR_CHANGING_PASSWORD, null);

        CompletableFuture<HttpResponse<byte[]>> handler = restClient.post
                (request, Global.changePasswordLoginFirstTimesWriteObject,
                        apiDistribute.getAPIChangePasswordFirstLogin(),
                        Collections.singletonMap("Content-Type", "application/json"));


        return handler.thenApply(httpResponse -> executeChangPassword(servletResponse, httpResponse));

    }


    /**
     * Get Account Auth from admin_management
     *
     * @param servletResponse
     * @param httpResponse
     * @return
     */
    private Response<?> auth(HttpServletResponse servletResponse, HttpResponse<byte[]> httpResponse) {
        Response<AccountAuth> accountAuthRes = Json.decode(httpResponse.body(), Global.accountAuthReader);

        servletResponse.setStatus(httpResponse.statusCode());

        Response.Metadata metadata = accountAuthRes.getMeta();
        if (!metadata.getCode().equals(Response.Metadata.OK_CODE))
            return accountAuthRes;

        var accountAuth = accountAuthRes.getData();

        if (accountAuth.getStatus() == AccountStatus.FIRST)
            return loginFirstTimes(accountAuth);

        String token = jwtProvider.findOrGenerateJwt(accountAuth, null);

        Response<Set<String>> actionsResponse = permissionCaller.getActionsByAccountId(accountAuth.getAccountId()).join();

        return Response.ofSucceeded(new LoginResponse(accountAuth, token, actionsResponse.getData()));
    }

    /**
     * Save the user's username if this user logs in for the first time
     *
     * @param accountAuth
     * @return
     */
    private Response<?> loginFirstTimes(AccountAuth accountAuth) {
        boSessionManager.saveSessionLoginFirstTime(accountAuth.getAccountId(), null);
        return Response.ofSucceeded(new LoginResponse(accountAuth, true));
    }

    /**
     * Execute change password
     *
     * @param servletResponse
     * @param httpResponse
     * @return
     */
    private Response<?> executeChangPassword(HttpServletResponse servletResponse, HttpResponse<byte[]> httpResponse) {
        Response<AccountAuth> accountAuthRes = Json.decode(httpResponse.body(), Global.accountAuthReader);

        servletResponse.setStatus(httpResponse.statusCode());

        Response.Metadata metadata = accountAuthRes.getMeta();
        if (!metadata.getCode().equals(Response.Metadata.OK_CODE))
            return accountAuthRes;

        var accountAuth = accountAuthRes.getData();

        boSessionManager.revokeSessionLoginFirstTime(accountAuth.getAccountId());

        String token = jwtProvider.findOrGenerateJwt(accountAuth, null);

        Response<Set<String>> actionsResponse = permissionCaller.getActionsByAccountId(accountAuth.getAccountId()).join();

        return Response.ofSucceeded(new LoginResponse(accountAuth, token, actionsResponse.getData()));
    }


}
