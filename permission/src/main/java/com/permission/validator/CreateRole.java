package com.permission.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CreateRoleValidator.class)
public @interface CreateRole {
    String message() default "Role's name exist!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
