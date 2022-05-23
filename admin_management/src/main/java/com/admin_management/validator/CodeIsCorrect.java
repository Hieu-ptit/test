package com.admin_management.validator;

import com.admin_management.model.bo.TableValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CodeIsCorrectValidator.class)
public @interface CodeIsCorrect {
    String message() default "Field does not exist !";

    TableValidate tableValidate();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
