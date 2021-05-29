package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            String[] splitCommand = scanner.nextLine().split("\\s+");

            String action = splitCommand[0];
            String lastCondition = "";

            if (action.equals("1")) {
                String textToAppend = splitCommand[1];
                stack.push(text.toString());
                text = appendText(text, textToAppend);

            } else if (action.equals("2")) {
                int textToErase = Integer.parseInt(splitCommand[1]);
                stack.push(text.toString());
                text = eraseText(text, textToErase);

            } else if (action.equals("3")) {
                int index = Integer.parseInt(splitCommand[1]);
                printChar(text, index);
            } else if (action.equals("4")) {
                text = new StringBuilder(stack.pop());

            }


        }


    }

    private static void printChar(StringBuilder text, int index) {
        System.out.println(text.charAt(index - 1)); // index CHECK!
    }

    private static StringBuilder eraseText(StringBuilder text, int textToErase) {
        return text.replace(text.length() - textToErase, text.length(), ""); // index check!
    }

    private static StringBuilder appendText(StringBuilder text, String textToAppend) {
        return text.append(textToAppend);
    }
}
