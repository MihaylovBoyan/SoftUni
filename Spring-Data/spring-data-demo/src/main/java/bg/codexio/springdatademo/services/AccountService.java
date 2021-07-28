package bg.codexio.springdatademo.services;

import bg.codexio.springdatademo.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public interface AccountService     {


    void transferBetweenAccounts(Long from, Long to, BigDecimal amount) throws InsufficientFundsException;

    void withdrawMoney(BigDecimal amount, Long id) throws InsufficientFundsException;

    void transferMoney(BigDecimal amount, Long id);

}
