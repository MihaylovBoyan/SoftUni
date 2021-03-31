package FinalExamPreparation;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> cityPeople = new TreeMap<>();


        while (!input.equals("Sail")) {

            String[] parts = input.split("\\|\\|");

            String city = parts[0];
            int people = Integer.parseInt(parts[1]);
            int gold = Integer.parseInt(parts[2]);


            if (!cityPeople.containsKey(city)) {
                cityPeople.put(city, new ArrayList<>());
                cityPeople.get(city).add(people);
                cityPeople.get(city).add(gold);

            } else {

                int currentPeople = cityPeople.get(city).get(0);
                int currentGold = cityPeople.get(city).get(1);
                cityPeople.get(city).set(0, currentPeople + people);
                cityPeople.get(city).set(1, currentGold + gold);

            }


            input = scanner.nextLine();

        }

        String event = scanner.nextLine();

        while (!event.equals("End")) {

            String[] tokens = event.split("=>");

            if (tokens[0].equals("Plunder")) {

                String city = tokens[1];
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);

                cityPeople.get(city).set(0, cityPeople.get(city).get(0) - people);
                cityPeople.get(city).set(1, cityPeople.get(city).get(1) - gold);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);

                if (cityPeople.get(city).get(0) <= 0 || cityPeople.get(city).get(1) <= 0) {
                    System.out.printf("%s has been wiped off the map!%n", city);
                    cityPeople.remove(city);
                }

            } else if (tokens[0].equals("Prosper")) {

                String city = tokens[1];
                int gold = Integer.parseInt(tokens[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");

                } else {
                    cityPeople.get(city).set(1, cityPeople.get(city).get(1) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, cityPeople.get(city).get(1));

                }
            }


            event = scanner.nextLine();
        }

        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityPeople.size());

        //gold in descending order
        cityPeople.entrySet().stream()
                .sorted((e, e1) -> e1.getValue().get(1).compareTo(e.getValue().get(1)))
                .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }
}

