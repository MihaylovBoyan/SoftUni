package JavaAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> info = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];


            info.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> innerMap = info.get(continent);

            innerMap.putIfAbsent(country, new ArrayList<>());
            innerMap.get(country).add(city);



        }

        for (Map.Entry<String, Map<String, List<String>>> entry : info.entrySet()) {
            String continent = entry.getKey();
            Map<String, List<String>> innerMap = entry.getValue();

            System.out.println(continent + ":");

            for (Map.Entry<String, List<String>> innerEntry : innerMap.entrySet()) {
                System.out.println("  " + innerEntry.getKey() + " -> "
                        + String.join(", ", innerEntry.getValue()));
            }

        }

    }
}
