package ProgrammingFundamentals;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyData = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String companyName = command.split(" -> ")[0];
            String employeeId = command.split(" -> ")[1];

            if (!companyData.containsKey(companyName)) {
                companyData.put(companyName, new ArrayList<>());
                companyData.get(companyName).add(employeeId);

            }
            if(!companyData.get(companyName).contains(employeeId)){
                companyData.get(companyName).add(employeeId);
            }


            command = scanner.nextLine();
        }

        companyData.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(p -> System.out.println("-- " + p));
                });

    }
}
