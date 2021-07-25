package FoodShortage;

public class Rebel extends AbstractCitizen {

    private String group;


    public Rebel(String name, int age, String group) {
        super(name,age);
        this.group = group;
    }


    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        this.addFood(5);
    }
}
