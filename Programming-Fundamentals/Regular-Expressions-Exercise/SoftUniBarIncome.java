package ProgrammingFundamentals;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "^%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|%$.]*?(?<price>\\d+\\.?\\d*)\\$$";

        Pattern patter = Pattern.compile(regex);
        double totalForAll = 0;

        while (!input.equals("end of shift")) {

            Matcher matcher = patter.matcher(input);
            if (matcher.find()) {
               String customer = matcher.group("customer");
               String product = matcher.group("product");
               double totalPrice = Integer.parseInt(matcher.group("quantity"))
                       * Double.parseDouble(matcher.group("price"));
               totalForAll += totalPrice;

                System.out.printf("%s: %s - %.2f%n", customer, product, totalPrice);
            }


            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalForAll);

    }
}
