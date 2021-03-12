package ProgrammingFundamentals;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();


        while (!line.equals("end")){
            StringBuilder result = new StringBuilder();
            for (int i = line.length() - 1; i >= 0 ; i--) {

              result.append(line.charAt(i));

            }
            System.out.printf("%s = %s%n", line, result.toString());

            line = scanner.nextLine();
        }

    }
}
