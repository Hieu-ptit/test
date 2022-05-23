package com.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String pattern() default "";

    String message() default "Password invalid !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
