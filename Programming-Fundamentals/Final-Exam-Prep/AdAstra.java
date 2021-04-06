package FinalExamPreparation;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([|#])(?<item>[A-Za-z]+\\s*[A-Za-z]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1";
        String input = scanner.nextLine();

        List<String> items = new LinkedList<>();

        int caloriesNeededPerDay = 2000;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int sumCalories = 0;

        while (matcher.find()) {

            String item = matcher.group("item");
            String date = matcher.group("date");
            String calories = matcher.group("calories");


            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d", item, date, Integer.parseInt(calories)));
            sumCalories += Integer.parseInt(matcher.group("calories"));

        }

        if (sumCalories == 0) {
            System.out.println("You have food to last you for: 0 days!");
        } else {

            int days = sumCalories / caloriesNeededPerDay;
            System.out.printf("You have food to last you for: %d days!%n", days);

            for (String item : items) {
                System.out.println(item);
            }


        }
    }
}