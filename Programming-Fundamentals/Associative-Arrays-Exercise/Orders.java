    package ProgrammingFundamentals;

    import java.util.LinkedHashMap;
    import java.util.Scanner;
    import java.util.Map;

    public class Orders {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            Map<String, Double> products = new LinkedHashMap<>();
            Map<String, Double> productsPrice = new LinkedHashMap<>();

            while (!input.equals("buy")) {

                String[] tokens = input.split("\\s+");
                String product = tokens[0];
                double initialPrice = Double.parseDouble(tokens[1]);
                double quantity = Double.parseDouble(tokens[2]);

                productsPrice.put(product, initialPrice);

                if (!products.containsKey(product)) {
                    products.put(product, quantity);
                } else {
                    products.put(product, products.get(product) + quantity);
                }


                input = scanner.nextLine();
            }

            for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {

                double finalSum = entry.getValue() * products.get(entry.getKey());
                System.out.printf("%s -> %.2f", entry.getKey(), finalSum);
                System.out.println();
            }


        }
    }
