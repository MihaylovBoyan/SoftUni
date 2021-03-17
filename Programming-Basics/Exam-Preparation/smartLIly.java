package Basics;

import java.util.Scanner;

public class smartLIly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMahine = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double moneyReceived = 10;
        double sum = 0;
        int toysCounter = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 == 0) {
                sum += moneyReceived;
                sum -= 1;
                moneyReceived += 10;

            } else {
                toysCounter++;
            }


        }

        double sumToys = toysCounter*toyPrice;
        double allSavings = sumToys+sum;
        if(allSavings>=washingMahine){
            System.out.printf("Yes! %.2f", allSavings-washingMahine);
        } else {
            System.out.printf("No! %.2f",washingMahine-allSavings);
        }
    }
}
