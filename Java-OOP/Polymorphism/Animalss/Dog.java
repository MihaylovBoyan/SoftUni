package Animalss;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s", getName(), getFavouriteFood() + System.lineSeparator() + "DJAAF");
    }
}
