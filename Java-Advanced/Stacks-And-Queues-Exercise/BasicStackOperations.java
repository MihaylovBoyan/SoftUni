package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] splitInput = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(splitInput[0]);
        int s = Integer.parseInt(splitInput[1]);
        int x = Integer.parseInt(splitInput[2]);

        String[] elementsToPush = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            stack.push(Integer.valueOf(elementsToPush[i]));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println("0");
            } else {
                int smallestNum = findSmallestNumInStack(stack);
                System.out.println(smallestNum);
            }
        }

    }

    private static int findSmallestNumInStack(ArrayDeque<Integer> stack) {
        int minNumber = Integer.MAX_VALUE;
        for (Integer e : stack) {
            if (e < minNumber) {
                minNumber = e;
            }
        }
        return minNumber;
    }
}
