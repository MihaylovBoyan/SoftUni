package JavaAdvanced;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shop = new TreeMap<>();

        while (!input.equals("Revision")) {

            String[] tokens = input.split(", ");
            String shopName = tokens[0];
            String productName = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shop.putIfAbsent(shopName, new LinkedHashMap<>());
            Map<String, Double> innerMap = shop.get(shopName);

            innerMap.put(productName, price);

            input = scanner.nextLine();
        }


        for (Map.Entry<String, Map<String, Double>> entry : shop.entrySet()) {
            System.out.println(entry.getKey() + "->");
            Map<String, Double> innerMap = entry.getValue();

            for (Map.Entry<String, Double> e : innerMap.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", e.getKey(), e.getValue());
            }
        }


    }
}
