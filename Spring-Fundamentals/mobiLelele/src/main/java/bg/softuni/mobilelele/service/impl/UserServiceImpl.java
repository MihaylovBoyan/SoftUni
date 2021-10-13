package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.model.entity.UserRoleEnum;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntityOptional.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(loginServiceModel.getRawPassword(),
                    userEntityOptional.get().getPassword());

            if (success) {
                UserEntity loggedInUser = userEntityOptional.get();
                currentUser.setLoggedIn(true)
                        .setUsername(loggedInUser.getUsername())
                        .setFirstName(loggedInUser.getFirstName())
                        .setLastName(loggedInUser.getLastName());

                loggedInUser.getRoles()
                        .forEach(r -> currentUser.addRole(r.getRole()));

            }
            return success;
        }

    }


    @Override
    public void logout() {
        currentUser.clean();
    }

    @Override
    public void initializeUsersAndRoles() {

        initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() != 0) {

            UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

            UserEntity admin = new UserEntity();
            admin.
                    setUsername("admin")
                    .setPassword("test")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setActive(true);

            admin.setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);

            UserEntity pesho = new UserEntity();
            admin.
                    setUsername("pesho")
                    .setPassword("test")
                    .setFirstName("Pesho")
                    .setLastName("Petrov")
                    .setActive(true);

            pesho.setRoles(Set.of(userRole));
            userRepository.save(pesho);
        }
    }

    private void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }
}
