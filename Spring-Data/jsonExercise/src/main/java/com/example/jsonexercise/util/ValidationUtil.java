package com.example.jsonexercise.util;

import javax.validation.Validator;

public interface ValidationUtil {


    <E> boolean isValid(E entity);
}
