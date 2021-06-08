package JavaAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> info = new TreeMap<>();

        while (!input.equals("end")) {
            String[] data = input.split("\\s+");

            String username = data[2].split("=")[1];
            String message = data[1].split("=")[1];
            String ip = data[0].split("=")[1];

            info.putIfAbsent(username, new LinkedHashMap<>());
            Map<String, Integer> innerMap = info.get(username);
            innerMap.putIfAbsent(ip, 0);
            innerMap.put(ip, innerMap.get(ip) + 1);

            input = scanner.nextLine();
        }


        info.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ": ");
                    int countEntry = e.getValue().size();
                    for (var ipEntry : e.getValue().entrySet()) {
                        if (countEntry > 1) {
                            System.out.print(ipEntry.getKey() + " => " +
                                    ipEntry.getValue() + ", ");
                        } else {
                            System.out.print(ipEntry.getKey() + " => " +
                                    ipEntry.getValue() + ".");
                        }
                        countEntry--;
                    }
                    System.out.println();

                });

    }
}
