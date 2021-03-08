package MidExamMarch;

import java.util.List;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class firstProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfVacation = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int countOfPeople = Integer.parseInt(scanner.nextLine());
        double priceForFuel = Double.parseDouble(scanner.nextLine());
        double foodExpensesPerPerson = Double.parseDouble(scanner.nextLine());
        double hotelPriceOneNightPerPerson = Double.parseDouble(scanner.nextLine());

        double totalHotelPriceForAll = hotelPriceOneNightPerPerson * countOfPeople * daysOfVacation;
        double totalFoodExpenses = foodExpensesPerPerson * countOfPeople * daysOfVacation;

        double currentExpenses = totalHotelPriceForAll + totalFoodExpenses;

        double discount = 0;

        if(countOfPeople > 10){
            discount = totalHotelPriceForAll * 0.25;
            currentExpenses = currentExpenses - discount;
        }

        for (int i = 1; i <= daysOfVacation; i++) {
            double distance = Double.parseDouble(scanner.nextLine());
            double consumedFuel = distance * priceForFuel;
            currentExpenses += consumedFuel;

            if(i % 3 == 0 || i % 5 == 0){

                double additionalExpenses = currentExpenses * 0.40;
                currentExpenses += additionalExpenses;
            }
            if(i % 7 == 0){

                double moneyReceived = currentExpenses / countOfPeople;
                currentExpenses -= moneyReceived;
            }
            if(currentExpenses >budget){
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", Math.abs(budget - currentExpenses));
                return;
            }


        }

        System.out.printf("You have reached the destination. You have %.2f$ budget left.", Math.abs(currentExpenses - budget));



    }
}
