package ProgrammingFundamentals;

import java.util.*;
import java.util.List;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Arrays.stream(input).filter(w -> w.length() % 2 == 0)
                .forEach(w -> System.out.println(w));

    }
}