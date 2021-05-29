package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean balanced = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '{' || currentSymbol == '[' || currentSymbol == '(') {
                stack.push(currentSymbol);
            } else if (currentSymbol == '}' ||
                    currentSymbol == ']' ||
                    currentSymbol == ')') {
                if(stack.isEmpty()){
                    balanced = false;
                    break;
                }
                char lastOpenBracket = stack.pop();

                if(lastOpenBracket == '(' && currentSymbol == ')'){

                } else if(lastOpenBracket == '[' && currentSymbol == ']'){

                } else if(lastOpenBracket == '{' && currentSymbol == '}'){

                } else {
                    balanced = false;
                }


            }

        }
        if(balanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
