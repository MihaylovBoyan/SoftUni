package JavaAdvanced;

import java.awt.*;

import java.util.*;
import java.util.List;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] info = scanner.nextLine().split(" ");
            String name = info[0];
            double grade = Double.parseDouble(info[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).add(grade);

        }

        students.entrySet().forEach(e -> {

            System.out.print(e.getKey() + " -> ");
            e.getValue().forEach(v -> System.out.printf("%.2f ", v));
            System.out.printf("(avg: %.2f)%n", e.getValue().stream().mapToDouble(el -> el).average().getAsDouble());

        });


    }
}
//       students.entrySet()
//                .stream()
//                .forEach(entry -> {
//                    double sum = 0;
//                    for (int i = 0; i < entry.getValue().size(); i++) {
//                        sum += entry.getValue().get(i);
//                    }
//                    double avgSum = sum / entry.getValue().size();
//
//                    System.out.print(entry.getKey() + " -> ");
//                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
//                    System.out.printf("(avg: %.2f)%n", avgSum);
//                });