package ProgrammingFundamentals;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>();

        String regex = ">{2}(?<item>[A-Za-z]+)<<(?<price>\\d+\\.\\d+|\\d+)!(?<quantity>\\d+)";
        double totalMoneySpent = 0;

        while (!input.equals("Purchase")){

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                furniture.add(matcher.group("item"));
                double currentPrice = Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
                totalMoneySpent += currentPrice;
            }

            input = scanner.nextLine();
        }


        System.out.println("Bought furniture: ");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalMoneySpent);

    }
}
