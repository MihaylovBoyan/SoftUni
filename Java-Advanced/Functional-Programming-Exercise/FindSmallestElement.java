package JavaAdvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> findSmallestIntegerIndex =
                list -> {
                    int min = Integer.MAX_VALUE;

                    for (Integer number : list) {
                        if(number < min){
                            min = number;
                        }
                    }
                    int i = list.lastIndexOf(min);
                    System.out.println(i);

                };

        findSmallestIntegerIndex.accept(numbers);




    }
}
