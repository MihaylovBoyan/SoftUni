package JavaAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> checkLength = str ->
                str.length() <= n;

        Arrays.stream(input)
                .filter(checkLength)
                .forEach(System.out::println);


    }

}
