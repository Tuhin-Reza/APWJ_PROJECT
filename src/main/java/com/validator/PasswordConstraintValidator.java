package com.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<IsValidPassword, String> {
    @Override
    public void initialize(IsValidPassword isValidPassword) {
    	 isValidPassword.message();
    }
 
    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {
        if(4>=password.length()) {
            return false;
        }
        return true;
    }
}