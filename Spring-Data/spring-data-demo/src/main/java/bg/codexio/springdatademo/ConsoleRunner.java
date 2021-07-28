package bg.codexio.springdatademo;

import bg.codexio.springdatademo.exceptions.InsufficientFundsException;
import bg.codexio.springdatademo.exceptions.UsernameAlreadyExistsException;
import bg.codexio.springdatademo.exceptions.userNotFoundException;
import bg.codexio.springdatademo.services.AccountService;
import bg.codexio.springdatademo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws UsernameAlreadyExistsException, userNotFoundException {

//        try {
//            this.userService.register(
//                    "pesho",
//                    25,
//                    new BigDecimal(1000)
//            );
//        } catch (UsernameAlreadyExistsException e) {
//            System.out.println(e.getClass().getSimpleName());
//        }
//
//        this.userService.addAccount(new BigDecimal(550),
//                1L);
//
//
//        try {
//            this.accountService.withdrawMoney(new BigDecimal(130), 1L);
//        } catch (InsufficientFundsException e) {
//            System.out.println(e.getClass().getSimpleName());
//        }
//
//        this.accountService.transferMoney(new BigDecimal(200), 2L);


        try {
            this.accountService.transferBetweenAccounts(
                    2L,
                    3L,
                    new BigDecimal(500)
            );
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

    }
}
