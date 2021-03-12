package ProgrammingFundamentals;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");

        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            if (text.contains(bannedWord)) {
                String censuredWord = censureWord(bannedWord);
                text = text.replace(bannedWord, censuredWord);

            }
        }
        System.out.println(text);


    }

    private static String censureWord(String word) {
        StringBuilder censuredWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {

            censuredWord.append("*");
        }
        return censuredWord.toString();
    }
}
