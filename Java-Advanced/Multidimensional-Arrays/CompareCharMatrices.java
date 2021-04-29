package JavaAdvanced;

import java.util.Scanner;

public class CompareCharMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readCharMatrix(scanner, rows, cols);
        char[][] secondMatrix = readCharMatrix(scanner, rows, cols);

        char[][] answer = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    answer[row][col] = firstMatrix[row][col];
                } else {
                    answer[row][col] = '*';
                }
            }
        }
        printMatrix(answer);

    }

    private static char[][] readCharMatrix(Scanner scanner, int rows, int cols) {


        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            char[] lineOfChars = line.replaceAll("\\s+", "").toCharArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = lineOfChars[col];
            }
        }

        return matrix;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
