package FinalExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder password = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Done")) {

            String[] parts = input.split(" ");
            String command = parts[0];

            if (command.equals("TakeOdd")) {

                for (int i = password.length() - 1; i >= 0; i--) {
                    if (i % 2 == 0) {
                        password.deleteCharAt(i);
                    }
                }
                System.out.println(password);

            } else if (command.equals("Cut")) {

                int index = Integer.parseInt(parts[1]);
                int length = Integer.parseInt(parts[2]);

                password.delete(index, index + length);
                System.out.println(password);


            } else if (command.equals("Substitute")) {


                String substring = parts[1];
                String substitute = parts[2];

                String passwordString = password.toString();

                if (passwordString.contains(substring)) {
                    passwordString = (password.toString().replace(substring, substitute));
                    System.out.println(passwordString);
                    password = new StringBuilder(passwordString);
                } else {
                    System.out.println("Nothing to replace!");
                }

            }


            input = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", password);

    }
}
