package BirthdayCelebration;

public class Pet implements Birthable, Identifiable{

    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName(){
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }


    @Override
    public String getId() {
        return null;
    }
}
