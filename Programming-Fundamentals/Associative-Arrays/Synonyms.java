package ProgrammingFundamentals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Synonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();

        for (int i = 0; i < n ; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if(!synonymDictionary.containsKey(word)){
                List<String> synonymsForCurrentWord = new ArrayList<>();
                synonymsForCurrentWord.add(synonym);
                synonymDictionary.put(word, synonymsForCurrentWord);
            } else {

                List<String> synonymsForCurrentWord = synonymDictionary.get(word);
                synonymsForCurrentWord.add(synonym);
                synonymDictionary.put(word, synonymsForCurrentWord);

            }

        }
        for (Map.Entry<String, List<String>> entry : synonymDictionary.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue() ));
        }

    }
}