package Basics;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int pieces = width * length;
        String command = scanner.nextLine();


        while (!command.equals("STOP")) {
            int parsed = Integer.parseInt(command);
            pieces -= parsed;
            if (pieces <= 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if (pieces <= 0) {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(pieces));

        } else {
            System.out.printf("%d pieces are left.", pieces);
        }

    }
}


