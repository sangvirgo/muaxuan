package com.demovalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrantValidation implements ConstraintValidator<CourseCode, String> {
    private String temp;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        temp=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null) {
            return false;
        }

        return s.startsWith(temp);
    }
}
