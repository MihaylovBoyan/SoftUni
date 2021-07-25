package FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyersByNames = new HashMap<>();

        for (int i = 0; i < n; i++) {

            Buyer buyer = createBuyer(scanner.nextLine());
            buyersByNames.put(buyer.getName(), buyer);

        }

        String name = scanner.nextLine();

        while (!name.equals("End")) {

            Buyer buyer = buyersByNames.get(name);

            if (buyer != null) {
                buyer.buyFood();
            }


            name = scanner.nextLine();
        }

        System.out.println(buyersByNames.values().stream()
                .mapToInt(Buyer::getFood)
                .sum());

    }

    private static Buyer createBuyer(String input) {

        String[] tokens = input.split("\\s+");

        if (tokens.length == 4) {

            return new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);

        } else {
            return new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

        }
    }
}
