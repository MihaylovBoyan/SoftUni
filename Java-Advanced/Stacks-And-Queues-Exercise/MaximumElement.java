package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String command = input[0];

            if (command.equals("1")) {

                int elementToPush = Integer.parseInt(input[1]);
                stack.push(elementToPush);

            } else if (command.equals("2")) {
                stack.pop();

            } else if (command.equals("3")) {

                System.out.println(findMaxElement(stack));


            }

        }


    }

    private static int findMaxElement(ArrayDeque<Integer> stack) {

        int maxNumber = Integer.MIN_VALUE;

        for (Integer integer : stack) {
            if(integer > maxNumber){
                maxNumber = integer;
            }
        }
        return maxNumber;

    }
}
