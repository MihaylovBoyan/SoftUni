package JavaAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumOfMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split(", ");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getElementsSum(matrix));


    }

    private static int getElementsSum(int[][] matrix) {
        
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        
        return sum;
        
    }


    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArray = firstMatrix[row];
            int[] secondArray = secondMatrix[row];

            if (firstArray.length != secondArray.length) {
                return false;
            }

            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }

        }


        return true;

    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

}
