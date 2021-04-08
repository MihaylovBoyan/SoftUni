package FinalExamPreparation;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        String regex = "([@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> validWords = new ArrayList<>();

        int counter = 0;

        while (matcher.find()) {
            counter++;

            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");

            StringBuilder reversedSecondWord = new StringBuilder(secondWord);
            reversedSecondWord.reverse();

            if (firstWord.equals(reversedSecondWord.toString())) {
                validWords.add(firstWord + " <=> " + secondWord);
            }



        }

        if (counter == 0) {
            System.out.println("No word pairs found!");

        } else {
            System.out.printf("%d word pairs found!%n", counter);
        }
        if (validWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {

            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", validWords));

        }
    }

}

