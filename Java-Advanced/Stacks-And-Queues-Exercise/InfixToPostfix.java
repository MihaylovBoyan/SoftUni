package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //input 5 / ( 3 + 2 ) output 5 3 2 + /

        //Input: 3 + 4
        //Push 3 to the output queue (whenever a number is read it is pushed to the output)
        //Push + (or its ID) onto the operator stack
        //Push 4 to the output queue
        //After reading the expression, pop the operators off the stack and add them to the output.
        //In this case there is only one, "+".


        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");

        for (String s : input) {
            if (Character.isDigit(s.charAt(0)) || Character.isLetter(s.charAt(0))) {

                queue.offer(s);

            } else {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else {
                    String lastOperator = stack.peek();
                    switch (s) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                stack.push(s);
                            } else {
                                queue.offer(stack.pop());
                                stack.push(s);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                queue.offer(stack.pop());
                            }
                            stack.push(s);
                            break;
                        case "(":
                            stack.push(s);
                            break;
                        case ")":
                            while (!stack.peek().equals("(")) {
                                queue.offer(stack.pop());
                            }
                            stack.pop();
                            break;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

