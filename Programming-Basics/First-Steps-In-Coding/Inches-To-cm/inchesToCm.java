package Basics.InchesTocm;

import java.util.Scanner;

public class inchesToCm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inches = Integer.parseInt(scanner.nextLine());
        double cm = inches * 2.54;
        System.out.println(cm);

    }
}
