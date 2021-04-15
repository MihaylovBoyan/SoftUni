package JavaAdvanced;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");

    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {

            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]) {
                    return false;
                }
            }

        }
        return true;

    }

    public static int[][] readMatrix(Scanner scanner) {

        String[] tokens = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            String[] line = scanner.nextLine()
                    .split(" ");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }

        }

        return matrix;

    }

}
