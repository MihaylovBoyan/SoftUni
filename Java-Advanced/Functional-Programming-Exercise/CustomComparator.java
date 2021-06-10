package JavaAdvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Comparator<Integer> comparator = (a, b) -> {
            if (isEven(a) && isOdd(b)) {
                return -1;
            } else if (isOdd(a) && isEven(b)) {
                return 1;
            } else if ((isEven(a) && isEven(b)) || isOdd(a) && isOdd(b)) {
                if (a <= b) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        };

        numbers.sort(comparator);
        numbers.forEach(n -> System.out.print(n + " "));
    }

    public static boolean isEven(int x) {
        return (x % 2 == 0);
    }

    public static boolean isOdd(int x) {
        return (x % 2 != 0);
    }
}
