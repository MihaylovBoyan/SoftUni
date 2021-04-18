package FinalExam;

import java.lang.reflect.AccessibleObject;
import java.util.Scanner;
import java.util.Map;
import java.util.List;

public class FirstProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();


        while (!command.equals("Complete")) {

            String[] tokens = command.split("\\s+");

            String action = tokens[0];

            if (action.equals("Make")) {

                if (tokens[1].equals("Upper")) {
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < password.length()) {

                        char charToReplace = password.charAt(index);
                        String replace = password.toString().replace(charToReplace, Character.toUpperCase(charToReplace));
                        password = new StringBuilder(replace);
                        System.out.println(password);
                    }
                } else if (tokens[1].equals("Lower")) {

                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < password.length()) {

                        char charToReplace = password.charAt(index);
                        String replace = password.toString().replace(charToReplace, Character.toLowerCase(charToReplace));
                        password = new StringBuilder(replace);
                        System.out.println(password);
                    }
                }

            } else if (action.equals("Insert")) {

                int index = Integer.parseInt(tokens[1]);
                if (index >= 0 && index < password.length()) {
                    char character = tokens[2].charAt(0);


                    password.insert(index, character);
                    System.out.println(password);
                }

            } else if (action.equals("Replace")) {


                char character = tokens[1].charAt(0);

                for (int i = 0; i < password.length(); i++) {
                    char current = password.charAt(i);
                    if (character == current) {

                        int value = Integer.parseInt(tokens[2]);
                        int sum = character + value;
                        String replace = password.toString().replace(character, (char) sum);
                        password = new StringBuilder(replace);
                        System.out.println(password);

                    }
                }


            } else if (action.equals("Validation")) {
                boolean hasDigit = false;
                boolean hasLower = false;
                boolean hasUpper = false;
                boolean hasInvalidSymbol = false;

                if (password.length() < 8) {
                    System.out.println("Password must be at least 8 characters long!");
                }
                for (int i = 0; i < password.length(); i++) {
                    char currentChar = password.charAt(i);

                    if (Character.isUpperCase(currentChar)) {
                        hasUpper = true;
                    }
                    if (Character.isDigit(currentChar)) {
                        hasDigit = true;
                    }
                    if (Character.isLowerCase(currentChar)) {
                        hasLower = true;
                    }

                    if (!(Character.isLetterOrDigit(currentChar) || currentChar == 95)) {
                        hasInvalidSymbol = true;
                    }

                }

                if (hasInvalidSymbol) {
                    System.out.println("Password must consist only of letters, digits and _!");
                }
                if (!hasUpper) {
                    System.out.println("Password must consist at least one uppercase letter!");
                }
                if (!hasLower) {
                    System.out.println("Password must consist at least one lowercase letter!");
                }
                if (!hasDigit) {
                    System.out.println("Password must consist at least one digit!");
                }


            }


            command = scanner.nextLine();
        }


    }
}
