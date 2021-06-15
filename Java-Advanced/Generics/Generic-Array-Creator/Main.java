package Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayCreator.create(13,"Java");
        Integer[] integers = ArrayCreator
                .create(Integer.class, 73, 69);

    }
}
