//package com.permission.validator;
//
//import com.admin_management.model.entity.Account;
//import com.admin_management.model.request.LoginRequest;
//import com.admin_management.repository.AccountRepository;
//import com.admin_management.util.Global;
//import com.common.util.ErrorMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
///**
// * Constraint for @Login
// */
//public class LoginValidator implements ConstraintValidator<Login, LoginRequest> {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void initialize(Login constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    /**
//     * Check phone in database
//     * Verify password
//     *
//     * @param loginRequest
//     * @param context
//     * @return
//     */
//    @Override
//    public boolean isValid(LoginRequest loginRequest, ConstraintValidatorContext context) {
//
//        context.disableDefaultConstraintViolation();
//
//        Account account = accountRepository.findByUsernameAndStatusIn(loginRequest.getUsername(), Global.lstStatusLogin).orElse(null);
//
//        if (account == null) {
//            context.buildConstraintViolationWithTemplate(String.format(ErrorMessage.ACCOUNT_NOT_FOUND_OR_ACTIVE, loginRequest.getUsername()))
//                    .addPropertyNode("username")
//                    .addConstraintViolation();
//            return false;
//        }
//
//        boolean validatePassword = passwordEncoder.matches(loginRequest.getPassword(), account.getHashPassword());
//
//        if (validatePassword) return true;
//
//        context.buildConstraintViolationWithTemplate(ErrorMessage.PASSWORD_WRONG)
//                .addPropertyNode("password")
//                .addConstraintViolation();
//
//        return false;
//    }
//
//
//}
