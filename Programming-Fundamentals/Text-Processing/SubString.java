package ProgrammingFundamentals;

import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String partToRemove = scanner.nextLine();
        String input = scanner.nextLine();
        String result = "";


        while (input.contains(partToRemove)) {

            input = removeParts(input, partToRemove);


        }
        System.out.println(input);
    }

    private static String removeParts(String input, String partToRemove) {
        int beginIndex = input.indexOf(partToRemove);
        int endIndex = beginIndex + partToRemove.length();
        return input.substring(0, beginIndex) + input.substring(endIndex);
    }
}
