package com.admin_management.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class NumberVariableValidator implements ConstraintValidator<NumberVariable, String> {

    private static final String NUMBER_VARIABLE_PATTERN = "^[A-Z0-9]{1,3}-[0-9]{1,3}.[0-9]{1,2}$";

    @Override
    public void initialize(NumberVariable constraintAnnotation) {
    }

    @Override
    public boolean isValid(String numberVariable, ConstraintValidatorContext context) {
        return isNumberVariable(numberVariable);
    }

    public boolean isNumberVariable(String numberVariable) {
        Pattern pattern = Pattern.compile(NUMBER_VARIABLE_PATTERN);

        return pattern.matcher(numberVariable).matches();
    }
}
