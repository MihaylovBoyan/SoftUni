import entity.Product;
import entity.Sale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        EntityManager entityManager = Persistence.createEntityManagerFactory("test")
                .createEntityManager();



    }
}
