package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");

        stack.push(Integer.parseInt(input[0]));

        for (int i = 1; i < input.length; i++) {
            String operation = input[i];
            int number = Integer.parseInt(input[++i]);
            int stackNum = stack.pop();

            if ("+".equals(operation)) {
                stack.push(number + stackNum);
            } else {
                stack.push(stackNum - number);
            }
        }

        System.out.println(stack.pop());


    }

}


