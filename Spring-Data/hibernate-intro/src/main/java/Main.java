import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("softuni");

        EntityManager entityManager = emf.createEntityManager();

        Engine engine = new Engine(entityManager);
        engine.run();

    }

}
