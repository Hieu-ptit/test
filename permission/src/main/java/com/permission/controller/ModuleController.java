package com.permission.controller;

import com.common.model.response.Response;
import com.permission.model.response.ModuleResponse;
import com.permission.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService service;

    @GetMapping
    public Response<List<ModuleResponse>> getAll() {
        return Response.ofSucceeded(service.getAll());
    }

    @GetMapping("/{role-id}")
    public Response<List<ModuleResponse>> getByRoleId(@Min(value = 0, message = "4201") @PathVariable(value = "role-id") int roleId) {
        return Response.ofSucceeded(service.getByRoleId(roleId));
    }


}
