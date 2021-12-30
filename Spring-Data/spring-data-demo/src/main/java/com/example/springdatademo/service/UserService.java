package com.example.springdatademo.service;

import java.math.BigDecimal;

public interface UserService {

    void register(String username,int age, BigDecimal initialAmount)
            throws UsernameAlreadyExistsException;

    void addAccount(BigDecimal amount, long id) throws UserNotFoundException;

}
