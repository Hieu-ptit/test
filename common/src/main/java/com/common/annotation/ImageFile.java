package com.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ImageFileValidator.class)
public @interface ImageFile {

    String message() default "4230";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
