package JavaAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();

        while (!line.equals("END")) {

            String[] input = line.split(", ");

            String direction = input[0];
            String carNumber = input[1];

            if (direction.equals("IN")) {

                parkingLot.add(carNumber);

            } else {

                parkingLot.remove(carNumber);

            }

            line = scanner.nextLine();

        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String number : parkingLot) {

                System.out.println(number);
            }
        }


    }
}
