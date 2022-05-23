package com.admin_management.service;

import com.admin_management.model.request.*;
import com.admin_management.model.response.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface AccountService {
    Page<? extends AccountInfo> findAll(String searchText, Integer page, Integer size, String field, Sort.Direction direction);

    AccountInfo getAccountById(String accountId);

    AccountInfo getAccount(String id);

    Boolean toggleOtp(String accountId, OtpRequest otpRequest);

    Boolean authenticationOtp(OtpRequest otpRequest);

    AccountDetail getInfoAccount(String accountId);

    LoginSuccessResponse login(LoginRequest loginRequest);

    LoginSuccessResponse register(RegisterDriverRequest request);

    LoginSuccessResponse changePasswordInLoginFirstTime(ChangePasswordLoginFirstTimes request);

    AdminRegisterResponse adminRegister(EmployeeRegisterRequest request);

    AccountUpdateResponse update(String id, AccountUpdateRequest accountUpdateRequest);

    Boolean changePassword(String accountId, ChangePasswordRequest request);

    Boolean resetPassword(String accountId);

    Boolean delete(String accountId);

    Boolean deleteDriver(String id);

}
