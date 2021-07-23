import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        System.out.println("Select ex number:");
        try {
            int exNum = Integer.parseInt(bufferedReader.readLine());

            switch (exNum) {

                case 2:
                    exTwo();
                case 3:
                    exThree();
                case 4:
                    exFour();
                case 5:
                    exFive();
                case 6:
                    exSix();
                case 7:
                    exSeven();
                case 8:
                    exEight();
                case 9:
                    exNine();
                case 10:
                    exTen();
                case 12:
                    exTwelve();
                case 13:
                    exThirteen();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    private void exThirteen() throws IOException {

        System.out.println("Enter town name:");
        String townName = bufferedReader.readLine();

        Town town = entityManager
                .createQuery("select t from Town t " +
                        "where t.name = :t_name ", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        int affectedRows = removeAddressesByTownId(town.getId());


        entityManager.remove(town);

        System.out.printf("%d address in %s is deleted", affectedRows, townName);
    }

    private int removeAddressesByTownId(Integer id) {

        List<Address> addresses = entityManager
                .createQuery("select a from Address a " +
                        "where a.town.id = :p_id ", Address.class)
                .setParameter("p_id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();

    }

    private void exTwelve() {

        @SuppressWarnings("unchecked")
        List<Object[]> rows = entityManager
                .createNativeQuery("select d.name, max(e.salary) as m_salary from departments d\n" +
                        "join employees e on d.department_id = e.department_id\n" +
                        "group by d.name\n" +
                        "having m_salary not between 30000 and 70000;")
                .getResultList();


    }

    private void exTen() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("update Employee e " +
                        "set e.salary = e.salary * 1.2 " +
                        "where e.department.id in :ids")
                .setParameter("ids", Set.of(1, 2, 4, 11))
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println(affectedRows);

    }

    private void exNine() {

    }

    private void exEight() throws IOException {

        System.out.println("Enter id:");
        int id = Integer.parseInt(bufferedReader.readLine());

        Employee employee = entityManager.find(Employee.class, id);
        System.out.printf("%s %s - %s%n", employee.getFirstName(),
                employee.getLastName(), employee.getJobTitle());

        Set<Project> projects = employee.getProjects();
        projects.forEach(p -> {
            System.out.println("      " + p.getName());
        });


    }

    private void exSeven() {

        List<Address> addresses = entityManager
                .createQuery("select a from Address a " +
                        "order by a.employees.size desc", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses
                .forEach(address -> {
                    System.out.printf("%s, %s - %d employees%n",
                            address.getText(),
                            address.getTown() == null
                                    ? "Unknown" : address.getTown().getName(),
                            address.getEmployees().size());
                });


    }

    private void exSix() throws IOException {

        System.out.println("Enter employee last name:");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager
                .createQuery("select e from Employee e " +
                        "where e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;

    }

    private void exFive() {

        entityManager
                .createQuery("select e from Employee e " +
                        "where e.department.name = :d_name " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s from %s - $%.2f%n", e.getFirstName(),
                            e.getLastName(), e.getDepartment().getName(),
                            e.getSalary());
                });

    }

    private void exFour() {

        entityManager.createQuery("select e from Employee e " +
                "where e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);


    }

    private void exThree() throws IOException {

        System.out.println("Enter employee full name:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery("select count(e) from Employee e " +
                "where e.firstName = :f_name and e.lastName = :l_name", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(singleResult == 0 ? "No" : "Yes");

    }

    private void exTwo() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t set t.name = " +
                "upper(t.name) where length(t.name) <= 5 ");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();
    }
}
