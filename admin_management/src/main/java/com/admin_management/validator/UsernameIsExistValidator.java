package com.admin_management.validator;


import com.admin_management.model.bo.TableValidate;
import com.admin_management.repository.AccountRepository;
import com.common.model.bo.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameIsExistValidator implements ConstraintValidator<UsernameIsExist, String> {

    private TableValidate tableDestination;
    private String status;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void initialize(UsernameIsExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.tableDestination = constraintAnnotation.tableValidate();
        this.status = constraintAnnotation.status().name();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        if (check(username)) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("4005")
                .addConstraintViolation();

        return false;
    }

    private boolean check(String phone) {
        switch (tableDestination) {
            case PROFILE:
                return false;
            case ACCOUNT:
                return accountRepository.findByUsernameAndStatus(phone, AccountStatus.valueOf(status)).isPresent();
            default:
                return true;
        }
    }


}
