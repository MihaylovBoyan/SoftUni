package ProgrammingFundamentals;

import java.util.*;
import java.util.List;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Arrays.stream(input).map(Integer::parseInt)
                .sorted((left, right) -> right.compareTo(left))
                .limit(3)
                .forEach(e-> System.out.print(e + " "));

    }
}
