package ProgrammingFundamentals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new HashMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        String winner = "";


        while (winner.equals("")) {
            String[] input = scanner.nextLine().split("\\s+");

            int quantity = 0;
            for (int i = 0; i < input.length; i++) {
                if (i % 2 == 0) {

                    quantity = Integer.parseInt(input[i]);

                } else {
                    String item = input[i].toLowerCase();
                    if (keyMaterials.containsKey(item)) {
                        keyMaterials.put(item, keyMaterials.get(item) + quantity);

                        if (keyMaterials.get(item) >= 250) {
                            if (item.equals("shards")) {
                                winner = "Shadowmourne";
                                keyMaterials.put(item, keyMaterials.get(item) - 250);
                                break;
                            } else if (item.equals("fragments")) {
                                winner = "Valanyr";
                                keyMaterials.put(item, keyMaterials.get(item) - 250);
                                break;
                            } else if (item.equals("motes")) {
                                winner = "Dragonwrath";
                                keyMaterials.put(item, keyMaterials.get(item) - 250);
                                break;
                            }
                        }

                    } else {
                        //if
                        if (junkMaterials.containsKey(item)) {
                            junkMaterials.put(item, junkMaterials.get(item) + quantity);
                        } else {
                            junkMaterials.put(item, quantity);
                        }
                    }
                }
            }



        }

        System.out.printf("%s obtained!%n", winner);
        keyMaterials.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .sorted((e,e1) -> e1.getValue().compareTo(e.getValue()))

                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMaterials.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() +": " + e.getValue()));

    }
}
