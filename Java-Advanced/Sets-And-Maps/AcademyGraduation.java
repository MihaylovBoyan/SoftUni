package JavaAdvanced;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> studentGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentGrades.put(name, grades);




        }
        for (Map.Entry<String, double[]> entry : studentGrades.entrySet()) {
            double average = Arrays.stream(entry.getValue()).average().getAsDouble();
            System.out.printf("%s is graduated with %f%n", entry.getKey(), average);
        }


    }
}
