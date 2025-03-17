package com.frimac.preoperational.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frimac.preoperational.domain.services.User.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByUserNameValidation implements ConstraintValidator<ExistByUserName, String>{

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userService == null) {
            return true;
        } else {
            return !userService.existsByUsername(username);
        }
    }

}