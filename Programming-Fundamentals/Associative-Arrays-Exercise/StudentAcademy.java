package ProgrammingFundamentals;

import java.util.Scanner;
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentInfo = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentInfo.containsKey(studentName)) {
                studentInfo.put(studentName, new ArrayList<>());
            }
            studentInfo.get(studentName).add(grade);

        }

        Map<String, Double> averageStudents = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentInfo.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(x -> x).average().getAsDouble();

            if (average >= 4.50) {
                averageStudents.put(entry.getKey(), average);

            }
        }

        averageStudents.entrySet().stream()
                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(s -> System.out.printf("%s -> %.2f%n", s.getKey(), s.getValue()));

    }
}
