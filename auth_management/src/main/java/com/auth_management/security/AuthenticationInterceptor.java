package com.auth_management.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth_management.model.bo.ApiSkipperAuthentication;
import com.common.model.response.Response;
import com.common.util.Constant;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import com.common.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;
    private final LoginSessionManager loginSessionManager;

    @Autowired
    public AuthenticationInterceptor(JwtProvider jwtProvider, LoginSessionManager loginSessionManager) {
        this.jwtProvider = jwtProvider;
        this.loginSessionManager = loginSessionManager;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        if (ApiSkipperAuthentication.isSkipAuthAPI(request)) return true;

        DecodedJWT decodedJWT = jwtProvider.validateJWT(request);
        if (decodedJWT == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().println(Json.encodeToString(Response.ofFailed(ErrorCode.NOT_AUTHENTICATION, ErrorMessage.NOT_AUTHENTICATION)));
            return false;
        }

        request.setAttribute(Constant.USER_ATTR, decodedJWT);

        String token = jwtProvider.getJWTToken(request);

        // add expire token
        loginSessionManager.saveLoginSession(decodedJWT.getClaim(Constant.ACCOUNT_ID).asString(), token, null);

        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {


    }





}
