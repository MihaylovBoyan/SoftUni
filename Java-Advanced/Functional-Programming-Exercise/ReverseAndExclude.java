package JavaAdvanced;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> checkIfDivisible = x -> x % n == 0;

        numbers.removeIf(checkIfDivisible);

        Consumer<List<Integer>> print = list ->
                list.forEach(e -> System.out.print(e + " "));
        print.accept(numbers);





    }
}
