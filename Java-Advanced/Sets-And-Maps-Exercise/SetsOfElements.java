package JavaAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        Set<Integer> firstSet = new LinkedHashSet<>(n);
        Set<Integer> secondSet = new LinkedHashSet<>(m);

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            firstSet.add(Integer.valueOf(line));
        }

        for (int i = 0; i < m; i++) {
            int line = Integer.parseInt(scanner.nextLine());

            secondSet.add(line);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(k -> System.out.print(k + " "));


    }
}
