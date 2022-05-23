package com.admin_management.validator;

import com.admin_management.model.bo.TableValidate;
import com.common.model.TotalStatus;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UsernameIsExistValidator.class)
public @interface UsernameIsExist {
    String message() default "Field does not exist !";

    TableValidate tableValidate();

    TotalStatus status() default TotalStatus.ACTIVE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
