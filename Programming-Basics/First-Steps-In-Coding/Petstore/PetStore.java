package Basics.Petstore;

import java.util.Scanner;

public class PetStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForSingleDog = 2.50;
        double priceForOtherAnimals = 4;

        int numberOfDogs = Integer.parseInt(scanner.nextLine());
        int numberOfOtherAnimals = Integer.parseInt(scanner.nextLine());

        double moneyForDogs = numberOfDogs * priceForSingleDog;
        double moneyForOtherAnimals = numberOfOtherAnimals * priceForOtherAnimals;

        double sum = moneyForDogs + moneyForOtherAnimals;

        System.out.printf("%.1f lv.", sum);
    }
}
