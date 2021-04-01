package ProgrammingFundamentals;

import java.util.Scanner;

public class HeroesOFCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String heroData = scanner.nextLine();
            String[] splitData = heroData.split(" ");
            String name = splitData[0];
            int hp = Integer.parseInt(splitData[1]);
            int mp = Integer.parseInt(splitData[2]);



        }

    }
}
