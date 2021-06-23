package ExamPreparation;

import java.util.Scanner;

public class Revolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] position = new int[2];
        char[][] matrix = new char[size][size];
        int n = Integer.parseInt(scanner.nextLine());


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("f")) {
                position[0] = row;
                position[1] = line.indexOf("f");
            }

        }
        boolean playerWon = false;

        while (n-- > 0 && !playerWon) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                playerWon = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                playerWon = movePlayer(position, matrix, +1, 0);

            } else if (command.equals("left")) {
                playerWon = movePlayer(position, matrix, 0, -1);

            } else if (command.equals("right")) {
                playerWon = movePlayer(position, matrix, 0, +1);

            }

        }

        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);


    }

    private static boolean movePlayer(int[] position, char[][] matrix
            , int rowModification, int colModification) {

        int row = position[0];
        int col = position[1];
        // up row - 1
        int newRow = indexCheck(row + rowModification, matrix.length);
        int newCol = indexCheck(col + colModification, matrix.length);

        boolean hasWon = false;

        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        } else if (matrix[newRow][newCol] == 'B') {
            newRow = indexCheck(newRow + rowModification, matrix.length);
            newCol = indexCheck(newCol + colModification, matrix.length);
            if(matrix[newRow][newCol] == 'T'){
                hasWon = true;
            }

        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;
        }


        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'f';
        position[0] = newRow;
        position[1] = newCol;
        return hasWon;
    }

    private static int indexCheck(int index, int size) {
        if (index < 0) {
            index = size - 1;
        } else if (index >= size) {
            index = 0;
        }



        return index;
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }


    }
}



