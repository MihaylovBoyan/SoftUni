package ProgrammingFundamentals;

import java.util.Scanner;

public class ExtractFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String[] arrayPath = path.split("\\\\");
        String lastPart = arrayPath[arrayPath.length - 1];

        String[] file = lastPart.split("\\.");
        String fileName = file[0];
        String fileExtension = file[1];

        System.out.printf("File name: %s%n", fileName) ;
        System.out.printf("File extension: %s%n", fileExtension) ;

    }
}
