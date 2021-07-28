package bg.codexio.springdatademo.repositories;

import bg.codexio.springdatademo.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {



}
