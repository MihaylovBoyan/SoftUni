package com.example.mobi.model.validator;

import com.example.mobi.model.binding.UserRegisterBindingModel;
import com.example.mobi.service.UserService;
import org.modelmapper.ModelMapper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class MatchingPasswordsValidator implements ConstraintValidator<MatchingPasswords, Object> {

    private String message;

    private final ModelMapper modelMapper;

    public MatchingPasswordsValidator(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void initialize(MatchingPasswords matchingPasswords) {
        this.message = matchingPasswords.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        UserRegisterBindingModel userRegisterBindingModel = modelMapper.map(value, UserRegisterBindingModel.class);

        boolean isValid = userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmPassword").addConstraintViolation();
        }

        return isValid;

    }
}
