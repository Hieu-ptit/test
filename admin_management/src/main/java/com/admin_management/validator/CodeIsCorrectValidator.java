package com.admin_management.validator;


import com.admin_management.model.bo.TableValidate;
import com.admin_management.repository.AccountRepository;
import com.admin_management.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CodeIsCorrectValidator implements ConstraintValidator<CodeIsCorrect, String> {

    private TableValidate tableDestination;
    private String status;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void initialize(CodeIsCorrect constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.tableDestination = constraintAnnotation.tableValidate();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {

        if (isIncorrectCode(code)) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("4005")
                .addConstraintViolation();

        return false;
    }

    private boolean isIncorrectCode(String code) {
        Pattern pattern = Pattern.compile("/^(SNV[A-Za-z0-9]*)$/");
        return pattern.matcher(code).matches();
    }

    private boolean check(String code) {
        switch (tableDestination) {
            case PROFILE:
                return false;
            case ACCOUNT:
                return accountRepository.findByCode(code).isPresent();
            default:
                return true;
        }

    }


}
