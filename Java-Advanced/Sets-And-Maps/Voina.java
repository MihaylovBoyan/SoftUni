package JavaAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashSet<Integer> firstDeck = readDeck(scanner);
        LinkedHashSet<Integer> secondDeck = readDeck(scanner);

        int rounds = 50;

        while (rounds-- > 0) {

            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);

            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }

        }

        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    public static int getFirst(LinkedHashSet<Integer> set) {

        for (Integer card : set) {
            return card;
        }
        return 0;

       // return set.stream().findFirst().orElse(0);

       // Iterator<Integer> iterator = set.iterator();
       // return iterator.next();

    }

    private static LinkedHashSet<Integer> readDeck(Scanner line) {
        return Arrays.stream(line.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
