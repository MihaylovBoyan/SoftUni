package ProgrammingFundamentals;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.List;

public class CountChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if(!chars.containsKey(currentChar) && currentChar != ' '){
                chars.put(currentChar, 1);
            } else if(currentChar != ' '){
                int newValue = chars.get(currentChar) + 1;
                chars.put(currentChar, newValue);
            }
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue());
            System.out.println();
        }

    }
}
