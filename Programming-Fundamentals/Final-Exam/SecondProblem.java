package FinalExam;

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[@#]+(?<colour>[a-z]{3,})[@#]+([^A-Za-z0-9]+)?\\/+(?<amount>\\d+)\\/+";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){

            String colour = matcher.group("colour");
            int amount = Integer.parseInt(matcher.group("amount"));

            System.out.printf("You found %d %s eggs!%n", amount, colour);

        }


    }
}
