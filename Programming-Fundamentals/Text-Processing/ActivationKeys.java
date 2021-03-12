package ProgrammingFundamentals;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder key = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();


        while (!command.equals("Generate")) {

            String[] tokens = command.split(">>>");
            String commandName = tokens[0];

            if (commandName.equals("Contains")) {
                String substring = tokens[1];

                if (key.indexOf(substring) != -1) {
                    System.out.printf("%s contains %s%n", key, substring);
                } else {
                    System.out.println("Substring not found!");
                }


            } else if (commandName.equals("Flip")) {

                String caseType = tokens[1];
                int startIndex = Integer.parseInt(tokens[2]);
                int endIndex = Integer.parseInt(tokens[3]);

                if (caseType.equals("Upper")) {
                    String upper = key.substring(startIndex, endIndex).toUpperCase();
                    key.replace(startIndex, endIndex, upper);
                    System.out.println(key);

                } else if (caseType.equals("Lower")) {
                    String lower = key.substring(startIndex, endIndex).toLowerCase();
                    key.replace(startIndex, endIndex, lower);
                    System.out.println(key);
                }

            } else if (commandName.equals("Slice")) {

                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);

                key.delete(startIndex, endIndex);
                System.out.println(key);

            }


            command = scanner.nextLine();
        }


        System.out.println("Your activation key is: " + key);
    }


}
