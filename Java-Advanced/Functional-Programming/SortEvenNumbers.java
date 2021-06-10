package JavaAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<IntStream, String> formatNumbers = str -> str.mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .toArray();

        String output = formatNumbers.apply(Arrays.stream(numbers));

        System.out.println(output);

        String sorted = formatNumbers.apply(Arrays.stream(numbers)
                .sorted());

        System.out.println(sorted);

    }
}
