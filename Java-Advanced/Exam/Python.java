package MatriciSViktor;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] position = new int[2];
        int foodSum = 0;

        String[] commands = scanner.nextLine().split(", ");

        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.split("\\s+");
            String s = line.replaceAll("\\s+", "");

            if (s.contains("s")) {
                position[0] = row;
                position[1] = s.indexOf("s");

            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("f")) {
                    foodSum++;
                }
            }
        }

        int length = 1;

        for (int i = 0; i < commands.length; i++) {



            String command = commands[i];

            if (command.equals("up")) {

                matrix[position[0]][position[1]] = "*";
                if (position[0] - 1 <= -1) {
                    position[0] = size - 1;
                } else {
                    position[0] = position[0] - 1;
                }
                if (matrix[position[0]][position[1]].equals("e")) {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                } else if (matrix[position[0]][position[1]].equals("f")) {

                    length++;
                    matrix[position[0]][position[1]] = "*";
                    foodSum--;
                }
            } else if (command.equals("down")) {

                matrix[position[0]][position[1]] = "*";
                if (position[0] + 1 >= matrix.length) {
                    position[0] = 0;
                } else {
                    position[0] = position[0] + 1;
                }
                if (matrix[position[0]][position[1]].equals("e")) {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                } else if (matrix[position[0]][position[1]].equals("f")) {
                    length++;
                    matrix[position[0]][position[1]] = "*";
                    foodSum--;

                }

            } else if (command.equals("left")) {

                matrix[position[0]][position[1]] = "*";
                if (position[1] - 1 <= -1) {
                    position[1] = size - 1;
                } else {
                    position[1] = position[1] - 1;
                }
                if (matrix[position[0]][position[1]].equals("e")) {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                } else if (matrix[position[0]][position[1]].equals("f")) {

                    length++;
                    matrix[position[0]][position[1]] = "*";
                    foodSum--;

                }

            } else if (command.equals("right")) {

                matrix[position[0]][position[1]] = "*";
                if (position[1] + 1 >= size) {
                    position[1] = 0;
                } else {
                    position[1] = position[1] + 1;
                }
                if (matrix[position[0]][position[1]].equals("e")) {
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                } else if (matrix[position[0]][position[1]].equals("f")) {
                    length++;
                    matrix[position[0]][position[1]] = "*";
                    foodSum--;

                }

            }

            if (foodSum <= 0) {
                System.out.printf("You win! Final python length is %d%n", length);
                return;
            }

        }

        boolean containsFood = false;
        int leftFood = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("f")) {
                    containsFood = true;
                    leftFood++;
                }
            }
        }

        if (containsFood) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", leftFood);
        } else {
            System.out.printf("You win! Final python length is %d%n", length);
        }


    }


}