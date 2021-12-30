package com.example.springdatademo.service;

import com.example.springdatademo.model.Account;
import com.example.springdatademo.repository.AccountRepository;
import com.example.springdatademo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        var account = accountRepository.findById(id).orElseThrow();

        if (account.getBalance().compareTo(amount) < 0) {
            throw new ArithmeticException();
        }

        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) {
        var account = accountRepository.findById(id).orElseThrow();
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }
}
