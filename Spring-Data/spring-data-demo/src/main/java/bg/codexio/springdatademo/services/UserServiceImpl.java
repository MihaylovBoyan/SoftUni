package bg.codexio.springdatademo.services;

import bg.codexio.springdatademo.exceptions.UsernameAlreadyExistsException;
import bg.codexio.springdatademo.exceptions.userNotFoundException;
import bg.codexio.springdatademo.models.Account;
import bg.codexio.springdatademo.models.User;
import bg.codexio.springdatademo.repositories.AccountRepository;
import bg.codexio.springdatademo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

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

        if (this.userRepository.existsByUsername(username))
            throw new UsernameAlreadyExistsException();

        var user = new User();
        user.setUsername(username);
        user.setAge(age);

        this.userRepository.save(user);


        this.saveAccount(initialAmount, user);
    }

    @Override
    public void addAccount(BigDecimal amount, Long id) throws userNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(userNotFoundException::new);

        this.saveAccount(amount, user);

    }

    private void saveAccount(BigDecimal amount, User user) {
        var account = new Account();
        account.setBalance(amount);
        account.setUser(user);

        this.accountRepository.save(account);
    }
}
