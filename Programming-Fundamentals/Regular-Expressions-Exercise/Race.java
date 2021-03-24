package ProgrammingFundamentals;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> participantsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new HashMap<>();

        Map<String, Integer> occurrences = new HashMap<>();
        StringBuilder name = new StringBuilder();
        int sum = 0;

        String regexName = "(?<charName>[A-Za-z])";
        String regexDistance = "(?<distance>\\d)";

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {

            Pattern pattern = Pattern.compile(regexName);
            Matcher matcher = pattern.matcher(input);

            Pattern pattern2 = Pattern.compile(regexDistance);
            Matcher matcher2 = pattern2.matcher(input);

            while (matcher.find()) {

                name.append(matcher.group());


            }

            while (matcher2.find()) {
                sum += Integer.parseInt(matcher2.group());
            }

            String nameAsString = String.valueOf(name);

            if (!occurrences.containsKey(nameAsString)) {

                occurrences.put(nameAsString, 1);

            } else {

                occurrences.put(nameAsString, occurrences.get(nameAsString) + 1);
            }

            if (participantsList.contains(nameAsString)) {

                if (occurrences.get(nameAsString).equals(1)) {
                    racers.put(nameAsString, sum);
                } else {

                    racers.put(nameAsString, racers.get(nameAsString) + sum);
                }


            }

            name.delete(0, name.length());
            sum = 0;
            input = scanner.nextLine();
        }


        List<String> listNamesSorted = new ArrayList<>();
        racers.entrySet().stream().sorted((e, e1) -> Integer.compare(e1.getValue(), e.getValue())).limit(3).forEach(e -> listNamesSorted.add(e.getKey()));

        for (int i = 1; i <= listNamesSorted.size(); i++) {
            if (i == 1) {
                System.out.printf("1st place: %s%n", listNamesSorted.get(0));
            } else if (i == 2) {
                System.out.printf("2nd place: %s%n", listNamesSorted.get(1));
            } else if (i == 3) {
                System.out.printf("3rd place: %s%n", listNamesSorted.get(2));
            }
        }

    }
}
