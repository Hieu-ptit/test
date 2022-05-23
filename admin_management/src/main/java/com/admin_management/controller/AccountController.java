package com.admin_management.controller;

import com.admin_management.model.request.*;
import com.admin_management.model.response.*;
import com.admin_management.service.AccountService;
import com.admin_management.service.impl.InfoInJwt;
import com.admin_management.util.Global;
import com.common.exception.BusinessException;
import com.common.model.response.Response;
import com.common.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/accounts")
@Validated
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;
    private final InfoInJwt infoInJwt;

    @GetMapping
    public Response<?> findAll(@Length(max = 99, message = "4158")
                               @RequestParam(value = "search-text", required = false) String searchText,
                               @Min(value = 1, message = "4156")
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @Min(value = 0, message = "4157")
                               @RequestParam(value = "size", defaultValue = "50") Integer size,
                               @RequestParam(value = "field-sort", defaultValue = "created_at") String field,
                               @RequestParam(value = "direction-sort", defaultValue = "DESC") Sort.Direction direction) {
        if (!StringUtils.isEmpty(field) && !Global.fieldSortAccount.contains(field))
            throw new BusinessException(ErrorCode.FIELD_SORT_INVALID, "Field sort: " + field + " invalid !");

        return Response.ofSucceeded(service.findAll(searchText, page - 1, size, field, direction));
    }

    @GetMapping("/infos")
    public Response<AccountInfo> getAccountById(@RequestHeader("Authorization") String token) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.getAccountById(accountId));
    }

    @GetMapping("/information")
    public Response<AccountInfo> getAccount(@RequestParam("id") String id) {
        return Response.ofSucceeded(service.getAccount(id));
    }

    @PostMapping("/authentication/otps")
    public Response<Boolean> authenticationOtp(@Valid @RequestBody OtpRequest otpRequest) {
        return Response.ofSucceeded(service.authenticationOtp(otpRequest));
    }

    @PostMapping("/toggles/otps")
    public Response<Boolean> toggleOtp(@RequestHeader("Authorization") String token,
                                                   @Valid @RequestBody OtpRequest otpRequest) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.toggleOtp(accountId, otpRequest));
    }

    @GetMapping("/details")
    public Response<AccountDetail> getInfoAccount(@NotBlank @RequestParam(value = "account-id") String accountId) {
        return Response.ofSucceeded(service.getInfoAccount(accountId));
    }

    @PostMapping("/login")
    public Response<LoginSuccessResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return Response.ofSucceeded(service.login(loginRequest));
    }

    @PostMapping("/register")
    public Response<LoginSuccessResponse> register(@Valid @RequestBody RegisterDriverRequest request) {
        return Response.ofSucceeded(service.register(request));
    }

    @PostMapping("/passwords/first")
    public Response<LoginSuccessResponse> changePasswordFirst(@Valid @RequestBody ChangePasswordLoginFirstTimes request) {
        return Response.ofSucceeded(service.changePasswordInLoginFirstTime(request));
    }

    @PostMapping("/admin/register")
    public Response<AdminRegisterResponse> register(@Valid @RequestBody EmployeeRegisterRequest request) {
        return Response.ofSucceeded(service.adminRegister(request));
    }

    @PutMapping("/{id}")
    public Response<AccountUpdateResponse> update(@NotBlank @PathVariable("id") String id,
                                                  @Valid @RequestBody AccountUpdateRequest accountUpdateRequest) {
        return Response.ofSucceeded(service.update(id, accountUpdateRequest));
    }

    @PutMapping("/passwords/changers")
    public Response<Boolean> changePassword(@RequestHeader("Authorization") String token,
                                            @Valid @RequestBody ChangePasswordRequest request) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.changePassword(accountId, request));
    }

    @PutMapping("/passwords/reset/{id}")
    public Response<Boolean> resetPassword(@NotBlank @PathVariable("id") String accountId) {

        return Response.ofSucceeded(service.resetPassword(accountId));
    }

    @DeleteMapping("/{id}")
    public Response<Boolean> delete(@NotBlank @PathVariable("id") String accountId) {
        return Response.ofSucceeded(service.delete(accountId));
    }

    @DeleteMapping("/driver/{id}")
    public Response<Boolean> deleteDriver(@NotBlank @PathVariable("id") String accountId) {
        return Response.ofSucceeded(service.deleteDriver(accountId));
    }

}
