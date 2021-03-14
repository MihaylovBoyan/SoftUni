package ProgrammingFundamentals;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] usernames = line.split(", ");
        boolean isValid = false;

        for (String username : usernames) {
            if (username.length() >= 3 && username.length() < 17) {
                isValid = true;
                for (int i = 0; i < username.length(); i++) {
                    char currentSymbol = username.charAt(i);
                    if (Character.isLetterOrDigit(currentSymbol) || currentSymbol == '-' || currentSymbol == '_') {
                        isValid = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    System.out.println(username);
                }
            }
        }


    }


}
