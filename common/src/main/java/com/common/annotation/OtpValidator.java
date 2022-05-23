package com.common.annotation;

import com.common.model.TypeVerify;
import com.common.service.OtpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OtpValidator implements ConstraintValidator<Otp, String> {

    @Autowired
    private OtpService otpService;

    private TypeVerify typeVerify;

    @Override
    public void initialize(Otp constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        typeVerify = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(String otp, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(otp) || verify(otp)) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(String.format("Otp invalid: %s", otp))
                .addConstraintViolation();

        return false;
    }

    private boolean verify(String otp) {
        switch (typeVerify) {
            case VERIFY:
                return otpService.verifyOtp(otp);
            case VERIFY_REVOKE:
                return otpService.verifyNRevokeOtp(otp);
        }
        return true;
    }

}
