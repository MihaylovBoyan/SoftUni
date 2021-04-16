package JavaAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String line = scanner.nextLine();

        while (!line.equals("PARTY")) {

            if (Character.isDigit(line.charAt(0))) {
                VIP.add(line);

            } else {

                regular.add(line);
            }


            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!line.equals("END")) {

            VIP.remove(line);
            regular.remove(line);


            line = scanner.nextLine();
        }

        int notShowed = VIP.size() + regular.size();

        System.out.println(notShowed);

        for (String v : VIP) {
            System.out.println(v);
        }

        for (String s : regular) {
            System.out.println(s);
        }

    }
}
