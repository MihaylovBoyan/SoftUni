package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", createVehicle(scanner.nextLine()));
        vehicleMap.put("Truck", createVehicle(scanner.nextLine()));

        Bus bus = createBus(scanner.nextLine());

        vehicleMap.put("Bus", bus);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = commandsCount; i > 0; i--) {
            String command = scanner.nextLine();

            String[] params = command.split("\\s+");
            double argument = Double.parseDouble(params[2]);

            if (command.contains("Drive") && command.contains("Bus")) {
                System.out.println(bus.driveWithPassengers(argument));
            } else if (command.contains("Drive")) {
                System.out.println(vehicleMap.get(params[1]).drive(argument));
            } else {
                try {
                    vehicleMap.get(params[1]).refuel(argument);
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }

        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }


    }

    private static Bus createBus(String input) {
        String[] tokens = input.split("\\s+");
        return new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }


    private static Vehicle createVehicle(String input) {

        String[] tokens = input.split("\\s+");

        switch (tokens[0]) {
            case "Car":
                return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            case "Bus":
                return createBus(input);
            default:
                throw new IllegalStateException("Unknown vehicle type");
        }


    }


}



