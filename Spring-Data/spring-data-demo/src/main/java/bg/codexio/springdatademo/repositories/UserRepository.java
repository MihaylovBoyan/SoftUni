package bg.codexio.springdatademo.repositories;

import bg.codexio.springdatademo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

}
