package ProgrammingFundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")){

            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String studentName = tokens[1];

            if(!courses.containsKey(course)){
                courses.put(course, new ArrayList<>());
            }

            courses.get(course).add(studentName);


            input = scanner.nextLine();
        }

        courses.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(),e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream().sorted(String::compareTo)
                            .forEach(student -> System.out.println("-- " + student));
                });

    }
}
