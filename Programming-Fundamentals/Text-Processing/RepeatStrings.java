package ProgrammingFundamentals;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
       StringBuilder output = new StringBuilder();

        for (String s : input) {
            int length = s.length();


            output.append(String.valueOf(s).repeat(length));
        }
        System.out.println(output);
    }
}

