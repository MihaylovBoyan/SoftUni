package ProgrammingFundamentals;

import java.util.*;
import java.util.List;

public class Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String s : input) {
            String wordInLowerCase = s.toLowerCase();
            if (counts.containsKey(wordInLowerCase)) {
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);

            } else {
                counts.put(wordInLowerCase, 1);
            }
        }

        List<String> oddWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddWords.add(entry.getKey());
            }

        }

        for (int i = 0; i < oddWords.size(); i++) {
            System.out.print(oddWords.get(i));
            if(i < oddWords.size() -1){
                System.out.print(", ");
            }
        }

    }
}
