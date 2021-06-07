package JavaAdvanced;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] inputCards = tokens[1].split(", ");

            Set<String> cards = new HashSet<>(Arrays.asList(inputCards));
            if (!players.containsKey(name)) {
                players.put(name, cards);
            } else {
                Set<String> setOfCards = players.get(name);
                setOfCards.addAll(cards);
                players.put(name, setOfCards);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            int points = getCardPoints(entry.getValue());
            System.out.println(entry.getKey() + ": " + points);
        }

    }

    private static int getCardPoints(Set<String> cards) {

        int sum = 0;
        Map<Character, Integer> powerOfCards = getPowerOfCars();

        for (String card : cards) {
            int points = 0;
            if (card.contains("10")) {
                char strength = card.charAt(2);
                points = 10 * powerOfCards.get(strength);
                sum += points;

            } else {
                char number = card.charAt(0);
                char strength = card.charAt(1);

                points = powerOfCards.get(strength) * powerOfCards.get(number);
                sum += points;
            }
        }

        return sum;
    }

    private static Map<Character, Integer> getPowerOfCars() {

        Map<Character, Integer> points = new HashMap<>();

        points.put('1', 1);
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;
    }
}
