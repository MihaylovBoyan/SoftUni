package FinalExamPreparation;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        List<String> coolEmoji = new ArrayList<>();

        String regexEmoji = "(::|\\*\\*)(?<emoji>[A-Z]{1}[a-z]{2,})\\1";

        String regexDigits = "\\d";

        Pattern digits = Pattern.compile(regexDigits);
        Pattern emoji = Pattern.compile(regexEmoji);

        Matcher matchDigits = digits.matcher(input);
        Matcher matchEmoji = emoji.matcher(input);

        long threshold = 1;

        while (matchDigits.find()) {

            int number = Integer.parseInt(matchDigits.group());
            threshold = threshold * number;

        }

        System.out.printf("Cool threshold: %d%n", threshold);

        int emojiCounter = 0;


        while (matchEmoji.find()) {
            emojiCounter++;
            coolEmoji.add(matchEmoji.group());

        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCounter);

        List<String> printEmoji = new ArrayList<>();

        for (String emojiC : coolEmoji) {

            long sum = 0;

            for (int i = 0; i < emojiC.length(); i++) {

                char currentChar = emojiC.charAt(i);
                if (Character.isLetter(currentChar)) {
                    sum = sum + currentChar;
                }
            }
            if (sum >= threshold) {
                printEmoji.add(emojiC);

            }
        }

        for (String s : printEmoji) {
            System.out.println(s);
        }


    }
}
