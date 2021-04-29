package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] male = scanner.nextLine().split(" ");
        String[] female = scanner.nextLine().split(" ");
        int matches = 0;


        Deque<Integer> stackMales = new ArrayDeque<>();
        Deque<Integer> queueFemales = new ArrayDeque<>();

        for (String s : male) {
            stackMales.push(Integer.parseInt(s));
        }

        for (String s : female) {
            queueFemales.offer(Integer.parseInt(s));
        }

        while (!stackMales.isEmpty() && !queueFemales.isEmpty()) {

            int woman = queueFemales.poll();

            while (woman <= 0 && !queueFemales.isEmpty()) {
                woman = queueFemales.poll();
            }
            if (woman % 25 == 0) {
                queueFemales.poll();
                continue;
            }


            int man = stackMales.pop();
            if (man <= 0) {
                stackMales.pop();
            }


            if (woman == man) {
                matches++;

            } else {
                stackMales.push(man - 2);

            }

        }


        System.out.println("Matches: " + matches);
        System.out.println("Males left: " +

                formatArrayDeque(stackMales));
        System.out.println("Females left: " +

                formatArrayDeque(queueFemales));


    }

    private static String formatArrayDeque(Deque<Integer> arrayDeck) {
        if (arrayDeck.size() == 0) {
            return "none";
        }
        return String.valueOf(arrayDeck.size());
    }
}

