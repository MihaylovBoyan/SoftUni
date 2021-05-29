package JavaAdvanced;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memoryForFib = new long[n + 1];
        System.out.println(getFibonacci(n));


    }

    public static long[] memoryForFib;

    private static long getFibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        if (memoryForFib[n] != 0) {
            return memoryForFib[n];
        }

        return memoryForFib[n] = getFibonacci(n - 1) + getFibonacci(n - 2);

    }
}
