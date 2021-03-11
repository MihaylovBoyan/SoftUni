package ProgrammingFundamentals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> inventory = new LinkedHashMap<>();


        String command = scanner.nextLine();

        while (!command.equals("stop")) {

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!inventory.containsKey(command)) {
                inventory.put(command, quantity);
            } else {
                inventory.put(command, inventory.get(command) + quantity);
            }


            command = scanner.nextLine();
        }

     inventory.forEach((k,v) -> System.out.println(k + " -> " + v));

    }
}
