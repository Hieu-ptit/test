package com.common.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Value("${app.pattern.phone}")
    private String defaultPattern;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        // initialize annotation do something
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(defaultPattern);
        return phoneNumber != null && pattern.matcher(phoneNumber).matches();
    }
}
