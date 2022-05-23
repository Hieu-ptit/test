package com.admin_management.mapper.impl;

import com.admin_management.caller.StationNameResponse;
import com.admin_management.model.entity.Account;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.entity.Profile;
import com.admin_management.model.request.AccountUpdateRequest;
import com.admin_management.model.request.EmployeeRegisterRequest;
import com.admin_management.model.response.*;
import com.common.model.bo.AccountStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    private final PasswordEncoder passwordEncoder;

    public AccountMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Map to LoginSuccess Response when login success
     *
     * @param account account
     * @return LoginSuccessResponse
     */
    public LoginSuccessResponse map(Account account) {

        LoginSuccessResponse response = new LoginSuccessResponse();
        response.setAccountId(account.getId());
        response.setUsername(account.getUsername());
        response.setStatus(account.getStatus());
        response.setCreatedAt(account.getCreatedAt());
        response.setUpdatedAt(account.getUpdatedAt());
        response.setOtp(account.getAuthenticationOtp());

        return response;
    }

    /**
     * Map to Driver when register success
     *
     * @param password password
     * @param phone phone
     * @return Account
     */
    public Account map(String password, String phone) {
        Account account = new Account();

        account.setUsername(phone);
        account.setHashPassword(passwordEncoder.encode(password));
        account.setStatus(AccountStatus.ACTIVE);

        return account;
    }

    /**
     * Map Account Info to Account
     *
     * @param account account
     * @return AccountInfo
     */
    public AccountInfo mapAccountInfo(Account account) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountId(account.getId());
        accountInfo.setUsername(account.getUsername());
        accountInfo.setStatus(account.getStatus());
        accountInfo.setCode(account.getCode());
        accountInfo.setCreatedAt(account.getCreatedAt());
        accountInfo.setUpdatedAt(account.getUpdatedAt());
        return accountInfo;
    }

    /**
     * Map Account Response from Account, Profile
     *
     * @param account account
     * @param profile profile
     * @return AccountResponse
     */
    public AccountResponse mapAccountResponse(Account account, Profile profile, Employees employees) {
        AccountResponse accountResponse = new AccountResponse(mapAccountInfo(account));
        if (profile != null)
            accountResponse.setName(profile.getName());
        if (employees != null) {
            accountResponse.setEmployeeId(employees.getId());
            accountResponse.setEmployeeCode(employees.getCode());
            accountResponse.setEmployeeName(employees.getName());
        }

        return accountResponse;
    }

    public Account map(EmployeeRegisterRequest request, Employees employees, Profile profile) {
        Account account = new Account();
        account.setCode(employees.getCode());
        account.setUsername(request.getUsername());
        account.setHashPassword(passwordEncoder.encode(request.getPassword()));
        account.setStatus(request.getStatus());
        account.setProfileId(profile.getId());
        return account;

    }

    public Profile mapProfile(Employees detail) {
        Profile profile = new Profile();
        profile.setName(detail.getName());
        profile.setPhone(detail.getPhone());
        profile.setAddress(detail.getAddress());
        return profile;

    }

    public AdminRegisterResponse mapNewAccount(Account account, Profile profile) {
        AdminRegisterResponse response = new AdminRegisterResponse();
        response.setAccountId(account.getId());
        response.setUsername(account.getUsername());
        response.setStatus(account.getStatus());
        response.setCreatedAt(account.getCreatedAt());
        response.setUpdatedAt(account.getUpdatedAt());
        response.setCode(account.getCode());
        response.setName(profile.getName());
        return response;
    }

    /**
     * map to account update
     *
     * @param account account
     * @param accountUpdateRequest accountUpdateRequest
     * @return Account
     */
    public Account mapUpdateAccount(Account account, AccountUpdateRequest accountUpdateRequest) {
        return account.setStatus(accountUpdateRequest.getStatus());
    }

    public AccountUpdateResponse mapUpdateResponse(Account account) {
        return new AccountUpdateResponse().setUsername(account.getUsername())
                .setCode(account.getCode())
                .setStatus(account.getStatus());
    }

    public AccountDetail map(Account account, Profile profile, RoleResponseDetail roleResponseDetail, Employees employees) {
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setAccountId(account.getId());
        accountDetail.setUsername(account.getUsername());
        accountDetail.setName(profile.getName());
        accountDetail.setCode(account.getCode());
        accountDetail.setRoleIds(new ArrayList<>());
        if (roleResponseDetail != null) {
            accountDetail.setRoleIds(roleResponseDetail.getRoleResponses().stream().map(RoleResponse::getId).collect(Collectors.toList()));
            accountDetail.setCreatedAt(account.getCreatedAt());
            accountDetail.setUpdatedAt(account.getUpdatedAt());
            accountDetail.setStatus(account.getStatus());
        }
        if (employees != null) {
            accountDetail.setEmployeeId(employees.getId());
            accountDetail.setEmployeeCode(employees.getCode());
            accountDetail.setEmployeeName(employees.getName());
        }

        return accountDetail;
    }

    public AccountInfo mapDetail(Account account, Profile profile) {
        return new AccountInfo().setAccountId(account.getId())
                .setUsername(account.getUsername())
                .setAvatar(profile.getAvatar())
                .setPhone(profile.getPhone())
                .setName(profile.getName())
                .setCode(account.getCode())
                .setStatus(account.getStatus());
    }

    public AccountInfo mapDetail(Account account, Profile profile, String position, List<StationNameResponse> stationNames) {

        AccountInfo accountInfo = mapDetail(account, profile);

        return accountInfo.setStationNames(stationNames).setPosition(position);
    }
}
