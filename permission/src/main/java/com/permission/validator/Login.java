//package com.permission.validator;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//
//
///**
// * Annotation are for Login only
// */
//@Target({ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = LoginValidator.class)
//public @interface Login {
//
//    String message() default "Username does not exist or password wrong !";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//
//}
