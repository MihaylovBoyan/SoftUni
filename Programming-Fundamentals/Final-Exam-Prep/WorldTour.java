package FinalExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();


        while (!input.equals("Travel")) {

            String[] command = input.split(":");

            if (command[0].equals("Add Stop")) {

                int index = Integer.parseInt(command[1]);
                String stop = command[2];
                if (indexIsValid(index, sb)) {
                    sb.insert(index, stop);
                }
                System.out.println(sb);

            } else if (command[0].equals("Remove Stop")) {

                int startIndex = Integer.parseInt(command[1]);
                int endIndex = Integer.parseInt(command[2]);

                if (indexIsValid(startIndex, sb) && indexIsValid(endIndex , sb)) {
                    sb.delete(startIndex, endIndex + 1);
                }
                System.out.println(sb);

            } else if (command[0].equals("Switch")) {

                String oldString = command[1];
                String newString = command[2];


                String destinationAsString = sb.toString();

                destinationAsString = destinationAsString.replace(oldString, newString);

                sb = new StringBuilder(destinationAsString);
                System.out.println(sb);

            }

            input = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", sb);

    }

    private static boolean indexIsValid(int index, StringBuilder sb) {

        return index >= 0 && index < sb.length();

    }


}
