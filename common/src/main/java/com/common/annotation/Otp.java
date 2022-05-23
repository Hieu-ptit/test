package com.common.annotation;

import com.common.model.TypeVerify;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OtpValidator.class)
public @interface Otp {

    TypeVerify type() default TypeVerify.VERIFY;

    String message() default "Otp invalid !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
