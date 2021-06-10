package JavaAdvanced;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> printConsumer = array ->
        {
            for (String s : array) {
                System.out.println(s);
            }
        };

        printConsumer.accept(names);

    }
}
