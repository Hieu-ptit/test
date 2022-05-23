package com.permission.validator;

import com.permission.model.request.RoleRequest;
import com.permission.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateRoleValidator implements ConstraintValidator<CreateRole, RoleRequest> {

    @Autowired
    private RoleRepository repository;

    /**
     * Initializes the validator in preparation for
     * {@link #isValid(RoleRequest, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(CreateRole constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Implements the validation logic.
     * The state of {@code createRoleRequest} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param roleRequest   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code createRoleRequest} does not pass the constraint
     */
    @Override
    public boolean isValid(RoleRequest roleRequest, ConstraintValidatorContext context) {
        if(repository.existsByName(roleRequest.getName())){
            context.buildConstraintViolationWithTemplate("4131")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

//        if(createRoleRequest.getBitSetModule() == null){
//            context.buildConstraintViolationWithTemplate("4132")
//                    .addPropertyNode("name").addConstraintViolation();
//            return false;
//        }

        return true;
    }
}
