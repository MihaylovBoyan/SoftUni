package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntityOptional.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(loginServiceModel.getRawPassword(),
                    userEntityOptional.get().getPassword());
        }


    }
}