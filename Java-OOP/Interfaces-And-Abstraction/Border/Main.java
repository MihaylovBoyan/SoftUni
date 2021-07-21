package Border;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> list = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {

            String[] tokens = line.split("\\s+");

            if (tokens.length == 2) {
                Identifiable r = new Robot(tokens[0], tokens[1]);
                list.add(r);
            } else {
                Identifiable c = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                list.add(c);
            }


            line = scanner.nextLine();
        }

        String fakeIdPostfix = scanner.nextLine();

        for (Identifiable identifiable : list) {

            if(identifiable.getId().endsWith(fakeIdPostfix)){
                System.out.println(identifiable.getId());
            }
        }


    }
}
