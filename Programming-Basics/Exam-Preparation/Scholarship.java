package Basics;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());
        double averageDegree = Double.parseDouble(scanner.nextLine());
        double minimalWage = Double.parseDouble(scanner.nextLine());
        double socialScholarship =0;
        double excellentScholarship =0;

        if(averageDegree<=4.50){
            System.out.println("You cannot get a scholarship!");
        }
        else if(averageDegree<5.50) {
            if (income < minimalWage) {
                socialScholarship = Math.floor(0.35 * minimalWage);
                System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
            } else {
                System.out.println("You cannot get a scholarship!");
            }
        }
        else {
            excellentScholarship =Math.floor(averageDegree*25);
            if(income<minimalWage) {
                socialScholarship = Math.floor(0.35*minimalWage);
            }
            if (socialScholarship>excellentScholarship){
                System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
            } else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentScholarship);
            }

        }
    }
}
