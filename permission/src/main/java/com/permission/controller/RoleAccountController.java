package com.permission.controller;

import com.common.model.response.Response;
import com.permission.model.request.CreateRoleAccountRequest;
import com.permission.model.request.UpdateRoleAccountRequest;
import com.permission.service.RoleAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/roles-account")
@RequiredArgsConstructor
public class RoleAccountController {

    private final RoleAccountService service;

    @PostMapping
    public Response<Boolean> create(@Valid @RequestBody CreateRoleAccountRequest createRoleAccountRequest) {
        return Response.ofSucceeded(service.create(createRoleAccountRequest));
    }

    @PutMapping
    public Response<Boolean> update(@Valid @RequestBody UpdateRoleAccountRequest updateRoleAccountRequest) {
        return Response.ofSucceeded(service.update(updateRoleAccountRequest));
    }
}
