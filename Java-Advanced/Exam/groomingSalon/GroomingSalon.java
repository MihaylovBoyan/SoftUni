package groomingSalon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                return data.remove(pet);
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {

        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;//String.format("%s %s%n", pet.getName(), pet.getOwner());
            }
        }
        return null;

    }


    public int getCount() {
        return data.size();
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append("The grooming salon has the following clients:");
        sb.append(System.lineSeparator());

        for (Pet pet : data) {
            sb.append(String.format("%s %s", pet.getName(), pet.getOwner()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }


}
