package FinalExamPreparation;

import javax.print.DocFlavor;
import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> pieceInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\|");

            String piece = input[0];
            String composer = input[1];
            String key = input[2];

            pieceInfo.put(piece, new ArrayList<>());
            pieceInfo.get(piece).add(composer);
            pieceInfo.get(piece).add(key);

        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {

            String[] tokens = command.split("\\|");

            String action = tokens[0];

            if (action.equals("Add")) {

                String piece = tokens[1];
                String composer = tokens[2];
                String key = tokens[3];

                if (!pieceInfo.containsKey(piece)) {
                    pieceInfo.put(piece, new ArrayList<>());
                    pieceInfo.get(piece).add(composer);
                    pieceInfo.get(piece).add(key);

                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);

                } else {
                    System.out.printf("%s is already in the collection!%n", piece);
                }

            } else if (action.equals("Remove")) {

                String pieceToRemove = tokens[1];

                if (pieceInfo.containsKey(pieceToRemove)) {
                    pieceInfo.remove(pieceToRemove);
                    System.out.printf("Successfully removed %s!%n", pieceToRemove);

                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
                }

            } else if (action.equals("ChangeKey")) {

                String piece = tokens[1];
                String newKey = tokens[2];

                if (pieceInfo.containsKey(piece)) {

                    pieceInfo.get(piece).set(1, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, pieceInfo.get(piece).get(1));

                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            }


            command = scanner.nextLine();
        }

        pieceInfo.entrySet().stream()
                .sorted((e, e1) -> e.getValue().get(0).compareTo(e1.getValue().get(0)))
                .sorted((e, e1) -> e.getKey().compareTo(e1.getKey()))
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));

    }
}
