package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        Map<String, Integer> robotInfo = new LinkedHashMap<>();
        Map<String, Integer> robotWorkingTime = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String[] robotData = input[i].split("-");
            String name = robotData[0];
            robotWorkingTime.put(name, 0);
        }


        ArrayDeque<String> products = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String[] robotData = input[i].split("-");
            String name = robotData[0];
            int seconds = Integer.parseInt(robotData[1]);
            robotInfo.put(name, seconds);
        }

        String startTime = scanner.nextLine();
        String[] splitTime = startTime.split(":");

        int hours = Integer.parseInt(splitTime[0]);
        int minutes = Integer.parseInt(splitTime[1]);
        int seconds = Integer.parseInt(splitTime[2]);

        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        String product = scanner.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {

            String currentProduct = products.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotWorkingTime);
            boolean isTaken = false;

            for (Map.Entry<String, Integer> robot : robotWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {

                    System.out.println(robot.getKey() + " - " + currentProduct  + " " + getStartTime(startTimeInSeconds));
                    robotWorkingTime.put(robot.getKey(), robotInfo.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken) {
                products.offer(currentProduct);
            }

        }


    }

    private static void decreaseWorkingTime(Map<String, Integer> robotWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotWorkingTime.entrySet()) {
            if (robot.getValue() > 0) {
                robotWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static String getStartTime(int startTimeInSeconds) {

        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;

        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);

    }
}
