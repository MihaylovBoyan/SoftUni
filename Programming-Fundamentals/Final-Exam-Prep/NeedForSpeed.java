package FinalExamPreparation;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> cars = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\|");

            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);

            cars.put(car, new ArrayList<>());
            cars.get(car).add(mileage);
            cars.get(car).add(fuel);


        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {

            String[] tokens = command.split(" : ");
            String action = tokens[0];
            String currentCar = tokens[1];


            if (action.equals("Drive")) {

                int distanceToDrive = Integer.parseInt(tokens[2]);
                int neededFuel = Integer.parseInt(tokens[3]);
                int currentFuel = cars.get(currentCar).get(1);

                if (neededFuel > currentFuel) {
                    System.out.println("Not enough fuel to make that ride");
                } else {

                    cars.get(currentCar).set(0, cars.get(currentCar).get(0) + distanceToDrive);
                    cars.get(currentCar).set(1, cars.get(currentCar).get(1) - neededFuel);

                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", currentCar, distanceToDrive, neededFuel);
                }

                if (cars.get(currentCar).get(0) >= 100000) {
                    System.out.printf("Time to sell the %s!%n", currentCar);
                    cars.remove(currentCar);
                }


            } else if (action.equals("Refuel")) {

                int currentFuel = cars.get(currentCar).get(1);
                int fuelToAdd = Integer.parseInt(tokens[2]);

                if (currentFuel + fuelToAdd <= 75) {

                    cars.get(currentCar).set(1, currentFuel + fuelToAdd);
                    System.out.printf("%s refueled with %d liters%n", currentCar, fuelToAdd);

                } else {

                    cars.get(currentCar).set(1, 75);
                    int fuel = 75 - currentFuel;
                    System.out.printf("%s refueled with %d liters%n", currentCar, fuel);
                }


            } else if (action.equals("Revert")) {

                int kilometers = Integer.parseInt(tokens[2]);
                int currentKilometers = cars.get(currentCar).get(0);

                int kilometersToSet = currentKilometers - kilometers;

                if (kilometersToSet >= 10000) {

                    cars.get(currentCar).set(0, kilometersToSet);
                    System.out.printf("%s mileage decreased by %d kilometers%n", currentCar, kilometers);

                } else {

                    cars.get(currentCar).set(0, 10000);

                }

            }


            command = scanner.nextLine();
        }

        cars.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((e, e1) -> e1.getValue().get(0).compareTo(e.getValue().get(0)))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));

    }
}
