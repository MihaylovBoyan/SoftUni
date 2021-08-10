package com.example.jsonexercise.util;

import javax.validation.Validator;

public interface ValidationUtil {

    <T> boolean isValid(T entity);

}
