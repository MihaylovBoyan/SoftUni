package com.example.springdatademo;

import com.example.springdatademo.service.UserService;
import com.example.springdatademo.service.UsernameAlreadyExistsException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {

        try {
            this.userService.register("pesho",
                    25,
                    new BigDecimal(1000));
        } catch (UsernameAlreadyExistsException e) {
            System.out.println("already exists");
        }

        userService.addAccount(BigDecimal.valueOf(554),1);
    }
}
