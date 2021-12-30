package com.example.springdatademo.service;

import com.example.springdatademo.model.Account;
import com.example.springdatademo.model.User;
import com.example.springdatademo.repository.AccountRepository;
import com.example.springdatademo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public void register(String username, int age, BigDecimal initialAmount) throws UsernameAlreadyExistsException {

        if (userRepository.existsByUsername(username)) {
            throw new UsernameAlreadyExistsException();
        }

        User user = new User();
        user.setUsername(username)
                .setAge(age);

        userRepository.save(user);

        var firstAccount = new Account();
        firstAccount.setBalance(initialAmount);
        firstAccount.setUser(user);

        accountRepository.save(firstAccount);


    }

    @Override
    public void addAccount(BigDecimal amount, long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        Account newAccount = new Account();
        newAccount.setBalance(amount);
        newAccount.setUser(user);
        accountRepository.save(newAccount);
    }
}
