package Basics;

import java.util.Scanner;

public class hotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double studio = 0;
        double apartment = 0;
        double priceStudio =0;
        double priceApartment =0;

        if(month.equals("May")|| month.equals("October")) {
            studio = 50;
            apartment =65;
            if(days>7 && days <=13){
                studio*=0.95;
            }
            if(days>=14){
                studio*=0.70;
                apartment *= 0.90;
            }
            priceStudio = studio * days;
            priceApartment = apartment*days;


        } else if(month.equals("June") || month.equals("September")){
            studio = 75.20;
            apartment =68.70;
            if(days>14){
                studio*=0.80;
                apartment *= 0.90;
            }
            priceStudio = studio * days;
            priceApartment = apartment*days;
        } else if(month.equals("July") || month.equals("August")){
            studio = 76;
            apartment =77;
            if(days>14){
                apartment *= 0.90;
            }
            priceStudio = studio * days;
            priceApartment = apartment*days;
        }
        System.out.printf("Apartment: %.2f lv.",priceApartment);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", priceStudio);
    }
}
