package com.permission.controller;

import com.common.model.response.Response;
import com.permission.model.request.AuthorRequest;
import com.permission.model.request.RoleRequest;
import com.permission.model.request.ValidateRolesRequest;
import com.permission.model.response.GetRoleResponse;
import com.permission.model.response.RoleResponseDetail;
import com.permission.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Validated
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public Response<List<GetRoleResponse>> findAll() {
        return Response.ofSucceeded(roleService.findAll());
    }

    @GetMapping("/infos")
    public Response<RoleResponseDetail> getRoleByAccountId(@NotBlank @RequestParam(value = "account-id") String accountId) {
        return Response.ofSucceeded(roleService.getRoleByAccountId(accountId));
    }

    /**
     * Internal call
     *
     * @param accountId accountId
     * @return Response<Set<String>>
     */
    @GetMapping("/actions")
    public Response<Set<String>> getActions(@NotBlank @RequestParam(value = "account-id") String accountId) {
        return Response.ofSucceeded(roleService.getActions(accountId));
    }

    @PostMapping
    public Response<Boolean> create(@Valid @RequestBody RoleRequest roleRequest) {
        return Response.ofSucceeded(roleService.create(roleRequest));
    }

    @PostMapping("/validators")
    public Response<Boolean> validate(@Valid @RequestBody ValidateRolesRequest validateRolesRequest) {
        return Response.ofSucceeded(roleService.validate(validateRolesRequest));
    }

    @PostMapping("/authorizations")
    public Response<Boolean> authorization(@Valid @RequestBody AuthorRequest authorRequest) {
        return Response.ofSucceeded(roleService.authorization(authorRequest));
    }

    @PutMapping("/{id}")
    public Response<Boolean> update(@Min(value = 0, message = "4201") @PathVariable(value = "id") Integer roleId,
                                    @Valid @RequestBody RoleRequest roleRequest) {
        return Response.ofSucceeded(roleService.update(roleId, roleRequest));
    }

    @DeleteMapping("/{id}")
    public Response<Boolean> delete(@Min(value = 0, message = "4194") @PathVariable("id") int id) {
        return Response.ofSucceeded(roleService.delete(id));
    }

}
