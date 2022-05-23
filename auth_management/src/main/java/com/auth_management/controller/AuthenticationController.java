package com.auth_management.controller;

import com.auth_management.model.request.ChangePasswordLoginFirstTimes;
import com.auth_management.service.AuthenticationService;
import com.common.model.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping
@Validated
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping({"/management/accounts/login", "/management/accounts/register"})
    public Response<?> registerNLogin(HttpServletRequest request, HttpServletResponse servletResponse) {
        return authenticationService.registerOrLogin(request, servletResponse).join();
    }


    @PostMapping("/management/auth/logout")
    public Response<Boolean> logout(HttpServletRequest request) {
        authenticationService.logout(request);
        return Response.ofSucceeded(true);
    }

    @PostMapping("/management/accounts/passwords/first")
    public CompletableFuture<Response<?>> changePasswordInLoginFirstTime(@Valid @RequestBody ChangePasswordLoginFirstTimes request,
                                                                         HttpServletResponse servletResponse) {
        return authenticationService.changePasswordInLoginFirstTime(request, servletResponse);
    }

}
