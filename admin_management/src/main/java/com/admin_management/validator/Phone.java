package com.admin_management.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    String message() default "Phone is wrong, please insert again";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
