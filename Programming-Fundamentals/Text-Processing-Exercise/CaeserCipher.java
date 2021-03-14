package ProgrammingFundamentals;

import java.util.Scanner;

public class CaeserCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            currentSymbol = (char) (currentSymbol  + 3);
            encryptedText.append(currentSymbol);
        }

        System.out.println(encryptedText);
    }
}
