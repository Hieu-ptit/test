package com.auth_management.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth_management.caller.PermissionCaller;
import com.auth_management.model.bo.ApiSkipperAuthentication;
import com.auth_management.model.bo.ApisSkipperAuthorization;
import com.auth_management.model.bo.Method;
import com.auth_management.model.request.AuthorRequest;
import com.auth_management.service.impl.InfoInJwt;
import com.auth_management.util.Global;
import com.common.model.ManagerClaim;
import com.common.model.response.Response;
import com.common.util.Constant;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthorizationInterceptor implements HandlerInterceptor {

    private final PermissionCaller permissionCaller;
    private final JwtProvider jwtProvider;
    private final InfoInJwt infoInJwt;
    private final LoginSessionManager loginSessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        if (ApiSkipperAuthentication.isSkipAuthAPI(request)) return true;

//        // TODO : bỏ đi sau khi đủ quyền
        DecodedJWT decodedJWT = (DecodedJWT) request.getAttribute(Constant.USER_ATTR);
//        if (!decodedJWT.getClaim("account_id").asString().equals("2")
//                && !decodedJWT.getClaim("account_id").asString().equals("b6c4f745-b1ca-4044-84f7-45b1ca8044f1"))
//            return true;

        if (ApisSkipperAuthorization.isSkipAuthAPI(request)) return true;


        Response<Boolean> authorization = permissionCaller.authorization(getAuthorRequest(request)).join();
        if (!authorization.getData()) {
            loginSessionManager.revokeLoginSession(decodedJWT.getClaim(Constant.ACCOUNT_ID).asString());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().println(Json.encodeToString(Response.ofFailed(ErrorCode.UNAUTHORIZED, ErrorMessage.UNAUTHORIZED)));
            return false;
        }

        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    private AuthorRequest getAuthorRequest(HttpServletRequest request){
        String token = jwtProvider.getJWTToken(request);

        ManagerClaim payload = infoInJwt.getPayload(token);

        return AuthorRequest.build()
                .setMethod(Method.valueOf(request.getMethod()))
                .setPath(request.getRequestURI())
                .setBitSetModule(payload.getBitSet());
    }

}
