package com.admin_management.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NumberVariableValidator.class)
public @interface NumberVariable {
    String message() default "Number variable is wrong, please insert again";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
