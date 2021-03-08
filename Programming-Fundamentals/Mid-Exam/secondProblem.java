package MidExamMarch;

import java.util.Arrays;
import java.util.Scanner;

import java.util.List;
import java.util.stream.Collectors;

public class secondProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        //int[]  num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // String[] num = scanner.nextLine().split(" ");
        // List<String> as = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());


        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {

            String[] tokens = command.split("\\s+");

            String action = tokens[0];

            if (action.equals("Urgent")) {

                String item = tokens[1];

                if (!shoppingList.contains(item)) {
                    shoppingList.add(0, item);
                }

            } else if (action.equals("Unnecessary")) {
                String item = tokens[1];
                shoppingList.remove(item);

            } else if (action.equals("Correct")) {
                String oldItem = tokens[1];
                String newItem = tokens[2];

                if (shoppingList.contains(oldItem)) {
                    shoppingList.set(shoppingList.indexOf(oldItem), newItem);
                }

            } else if (action.equals("Rearrange")) {
                String item = tokens[1];
                if (shoppingList.contains(item)) {
                    shoppingList.add(item);
                    shoppingList.remove(item);
                }

            }


            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", shoppingList));

    }
}
