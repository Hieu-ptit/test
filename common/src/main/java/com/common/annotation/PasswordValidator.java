package com.common.annotation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private String pattern;

    @Value("${app.pattern.password}")
    private String defaultPattern;

    @Override
    public void initialize(Password constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.pattern = StringUtils.isEmpty(constraintAnnotation.pattern()) ? defaultPattern : constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        String patternCp = pattern;
        if (Pattern.compile(patternCp).matcher(password).matches()) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("4006")
                .addConstraintViolation();
        return false;
    }
}
