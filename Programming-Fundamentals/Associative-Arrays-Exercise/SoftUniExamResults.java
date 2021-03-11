package ProgrammingFundamentals;

import java.util.*;
import java.util.List;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userPoints = new HashMap<>();
        Map<String, Integer> submitsCount = new HashMap<>();


        String command = scanner.nextLine();


        while (!command.equals("exam finished")) {
            String[] tokens = command.split("-");
            String username = tokens[0];

            if (tokens.length == 3) {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);

                if (!userPoints.containsKey(username)) {
                    userPoints.put(username, points);
                } else {
                    int currentPoints = userPoints.get(username);
                    if (points > currentPoints) {
                        userPoints.put(username, +points);
                    }
                }
                if (!submitsCount.containsKey(language)) {
                    submitsCount.put(language, 1);
                } else {
                    submitsCount.put(language, submitsCount.get(language) + 1);
                }

            } else {
                userPoints.remove(username);
            }


            command = scanner.nextLine();
        }

        System.out.println("Results:");

        userPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));

        System.out.println("Submissions:");

        submitsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

    }
}
