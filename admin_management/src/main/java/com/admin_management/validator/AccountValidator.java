package com.admin_management.validator;

import com.admin_management.model.entity.Account;
import com.admin_management.model.request.ChangePasswordRequest;
import com.admin_management.model.request.EmployeeRegisterRequest;
import com.admin_management.repository.AccountRepository;
import com.common.exception.BusinessException;
import com.common.model.bo.AccountStatus;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountValidator {

    private final AccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void validateRequest(EmployeeRegisterRequest request) {

        if (repository.existsByUsernameAndStatusNot(request.getUsername(), AccountStatus.DELETE))
            throw new BusinessException(ErrorCode.USERNAME_IS_EXISTED, ErrorMessage.USERNAME_IS_EXISTED);

//        boolean isExitsCodeOrUsername = repository.findFirstByCodeOrUsername(request.getCode(), request.getUsername()).isPresent();
//        if (isExitsCodeOrUsername)
//            throw new BusinessException(ErrorCode.CODE_OR_USERNAME_IS_EXISTED, ErrorMessage.CODE_OR_USERNAME_IS_EXISTED);
    }

    public Account validate(String accountId) {

        return repository.findByIdAndStatus(accountId, AccountStatus.ACTIVE)
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.ACCOUNT_NOT_FOUND,
                                String.format(ErrorMessage.ACCOUNT_NOT_FOUND_OR_ACTIVE, accountId)));

    }

    public Account validateAccount(String accountId) {

        return repository.findByIdAndStatusNot(accountId, AccountStatus.DELETE)
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.ACCOUNT_NOT_FOUND,
                                String.format(ErrorMessage.ACCOUNT_NOT_FOUND_OR_ACTIVE, accountId)));
    }

    public void validateChangePassword(Account account, ChangePasswordRequest request) {

        if (!comparePassword(request.getPasswordOld(), account.getHashPassword(), passwordEncoder))
            throw new BusinessException(ErrorCode.WRONG_PASSWORD, ErrorCode.WRONG_PASSWORD.getMessage());

        if (!request.getPasswordNew().equals(request.getRepeatPassword()))
            throw new BusinessException(ErrorCode.PASSWORD_NEW_WRONG, ErrorCode.PASSWORD_NEW_WRONG.getMessage());

    }

    public boolean comparePassword(String password, String hashPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, hashPassword);
    }
}
