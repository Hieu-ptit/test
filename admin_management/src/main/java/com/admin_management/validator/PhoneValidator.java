package com.admin_management.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String PHONE_PATTERN = "^([\\+84|84|0]+(3|5|7|8|9))+([0-9]{8})$";

    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {

        if (isPhone(phone)) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("4811")
                .addConstraintViolation();

        return false;
    }

    public boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);

        return pattern.matcher(phone).matches();
    }
}
