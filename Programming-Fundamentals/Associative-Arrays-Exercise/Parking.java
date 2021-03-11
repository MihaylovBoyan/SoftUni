package ProgrammingFundamentals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> driverInfo = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());



        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            String[] tokens = command.split("\\s+");
            String username = tokens[1];

            if (tokens.length == 3) {

                String licenseNumber = tokens[2];

                if (!driverInfo.containsKey(username)) {
                       driverInfo.put(username, licenseNumber);
                    System.out.printf("%s registered %s successfully%n", username, driverInfo.get(username));
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", driverInfo.get(username));
                }


            } else {

                if (!driverInfo.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);

                } else{
                    System.out.printf("%s unregistered successfully%n", username);
                    driverInfo.remove(username);

                }

            }


        }

        driverInfo.forEach((k,v) -> System.out.println(k + " => " + v));

    }
}

