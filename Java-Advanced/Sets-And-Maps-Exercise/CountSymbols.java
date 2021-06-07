package JavaAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();
        Map<Character, Integer> occurrences = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);


            if (!occurrences.containsKey(currentChar)) {
                occurrences.put(currentChar, 1);
            } else {
                occurrences.put(currentChar, occurrences.get(currentChar) + 1);
            }

        }

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
