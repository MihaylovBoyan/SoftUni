package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            stack.push(Integer.parseInt(input[i]));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }


    }
}
