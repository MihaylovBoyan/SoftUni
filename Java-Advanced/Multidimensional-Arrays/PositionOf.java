package JavaAdvanced;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);


        int numberToFind = Integer.parseInt(scanner.nextLine());
        boolean foundNumber = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (numberToFind == matrix[row][col]) {
                    foundNumber = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        if (!foundNumber) {
            System.out.println("not found");
        }

    }

    private static int[][] readMatrix(Scanner scanner) {

        String[] input = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            input = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }

        return matrix;
    }
}
