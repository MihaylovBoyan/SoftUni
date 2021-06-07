package JavaAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();


        double[] numsArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double v : numsArray) {
            if(!numbers.containsKey(v)){
                numbers.put(v, 1);
            } else {
                numbers.put(v, numbers.get(v) +1);
            }
        }
        
        numbers.forEach((k,v) -> System.out.printf("%.1f -> %d%n", k,v));

    }
}
