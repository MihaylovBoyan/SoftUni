package FinalExam;

import java.util.*;

public class ThirdProblem {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> shop = new HashMap<>();
        int allSold = 0;

        String command = scanner.nextLine();

        while (!command.equals("Complete")) {

            String[] tokens = command.split("\\s+");

            String action = tokens[0];
            int quantity = Integer.parseInt(tokens[1]);
            String food = tokens[2];

            if (action.equals("Receive")) {

                if (!shop.containsKey(food)) {
                    if (quantity >= 0) {
                        shop.put(food, quantity);
                    }
                } else {
                    if (quantity >= 0) {
                        shop.put(food, shop.get(food) +quantity);
                    }
                }


            } else if (action.equals("Sell"))

                if (!shop.containsKey(food)) {
                    System.out.printf("You do not have any %s.%n", food);
                } else {

                    if (quantity > shop.get(food)) {
                        allSold += shop.get(food);
                        System.out.printf("There aren't enough %s. You sold the last %d of them.%n", food, shop.get(food));
                        shop.remove(food);
                    } else {

                        shop.put(food, shop.get(food) - quantity);
                        allSold += quantity;
                        if (shop.get(food) <= 0) {
                            shop.remove(food);
                        }
                            System.out.printf("You sold %d %s.%n", quantity, food);

                    }

                }
            command = scanner.nextLine();
        }

        shop.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        System.out.printf("All sold: %d goods", allSold);

    }
}
