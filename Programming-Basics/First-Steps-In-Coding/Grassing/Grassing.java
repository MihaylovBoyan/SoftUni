package Basics.Grassing;

import java.util.Scanner;

public class Grassing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceOneSquareMeter = 7.61;
        double metersToBeGrassed = Double.parseDouble(scanner.nextLine());

        double metersPrice = priceOneSquareMeter * metersToBeGrassed;
        double discount = metersPrice * 0.18;
        double finalPrice = metersPrice - discount;


        System.out.printf("The final price is: %.2f lv.%n", finalPrice);
        System.out.printf("The discount is: %.2f lv.", discount);

    }
}
