package FoodShortage;

public class Citizen extends AbstractCitizen implements Identifiable {

    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, age);
        this.id = id;
        this.birthDate = birthDate;

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void buyFood() {
        this.addFood(10);
    }

}
