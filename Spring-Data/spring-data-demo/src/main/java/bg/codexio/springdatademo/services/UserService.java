package bg.codexio.springdatademo.services;

import bg.codexio.springdatademo.exceptions.UsernameAlreadyExistsException;
import bg.codexio.springdatademo.exceptions.userNotFoundException;

import java.math.BigDecimal;

public interface UserService {

    void register(String username, int age, BigDecimal initialAmount) throws UsernameAlreadyExistsException;

    void addAccount(BigDecimal amount, Long id) throws userNotFoundException;
}
