package FinalExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {

            String[] tokens = input.split("\\|");

            String command = tokens[0];

            if (command.equals("Move")) {

                int numberOfLetters = Integer.parseInt(tokens[1]);

                move(sb, numberOfLetters);

            } else if (command.equals("Insert")) {

                int index = Integer.parseInt(tokens[1]);
                String value = tokens[2];

                insertValue(sb, index, value);


            } else if (command.equals("ChangeAll")) {

                String substring = tokens[1];
                String substitution = tokens[2];

                sb = replaceAll(sb, substring, substitution);
            } else {
                break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", sb);


    }

    private static StringBuilder move(StringBuilder sb, int numberOfLetters) {

        if (numberOfLetters >= 0 && numberOfLetters < sb.length()) {
            String substring = sb.substring(0, numberOfLetters);
            sb.delete(0, numberOfLetters);
            sb.append(substring);
        }

        return sb;
    }

    private static StringBuilder replaceAll(StringBuilder sb, String substring, String substitution) {

        if (sb.toString().contains(substring)) {
            String replace = sb.toString().replace(substring, substitution);
            sb = new StringBuilder(replace);
        }

        return sb;
    }

    private static StringBuilder insertValue(StringBuilder sb, int index, String value) {

        if (index >= 0 && index <= sb.length()) {
            sb.insert(index, value);
        }
        return sb;
    }
}
