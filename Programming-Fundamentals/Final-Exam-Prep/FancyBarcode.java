package FinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String barcodeRegex = "(@#+)(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern patternBarcode = Pattern.compile(barcodeRegex);


        for (int i = 0; i < n; i++) {

            String barcode = scanner.nextLine();

            Matcher matcherBarcode = patternBarcode.matcher(barcode);


            if (matcherBarcode.find()) {

                StringBuilder sum = new StringBuilder();

                String product = matcherBarcode.group("product");

                for (int j = 0; j < product.length(); j++) {
                    char currentChar = product.charAt(j);
                    if (Character.isDigit(currentChar)) {
                        sum.append(currentChar);
                    }
                }
                if (sum.toString().equals("")) {
                    System.out.println("Product group: 00");

                } else if (sum.length() > 0) {
                    System.out.printf("Product group: %s%n", sum);
                } else {
                    System.out.printf("Product group: %s%n", 0);
                }


            } else {
                System.out.println("Invalid barcode");
            }


        }

    }
}
