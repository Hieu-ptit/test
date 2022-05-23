package com.common.annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class ImageFileValidator implements ConstraintValidator<ImageFile, MultipartFile> {

    private static final Set<String> extendValid = new HashSet<>(Arrays.asList("image/png", "image/jpeg", "image/png"));

    @Override
    public void initialize(ImageFile constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        return extendValid.contains(file.getContentType());
    }

}
