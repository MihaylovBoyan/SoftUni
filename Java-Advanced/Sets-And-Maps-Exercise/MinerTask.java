package JavaAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String, Integer> bag = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!bag.containsKey(input)) {
                bag.put(input, quantity);
            } else {
                bag.put(input, bag.get(input) + quantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : bag.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
