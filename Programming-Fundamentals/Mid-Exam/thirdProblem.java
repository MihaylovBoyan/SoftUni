package MidExamMarch;

import java.util.Arrays;
import java.util.Scanner;

import java.util.List;

public class thirdProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] houses = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        int currentIndex = 0;

        String command = scanner.nextLine();

        while (!command.equals("Love!")) {
            String[] tokens = command.split("\\s+");

            int length = Integer.parseInt(tokens[1]);
            currentIndex += length;
            if (currentIndex >= houses.length || currentIndex < 0) {
                currentIndex = 0;
            }

            if (houses[currentIndex] <= 0) {

                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);

            }
            houses[currentIndex] = houses[currentIndex] - 2;
            if (houses[currentIndex] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", currentIndex);
            }


            command = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);

        int counter = 0;

        for (int house : houses) {
            if(house > 0){
                counter++;
            }
        }
        if (counter != 0) {
            System.out.printf("Cupid has failed %d places.%n", counter);
        } else {
            System.out.println("Mission was successful.");
        }

    }
}
