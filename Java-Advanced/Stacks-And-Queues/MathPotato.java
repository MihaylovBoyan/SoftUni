package JavaAdvanced;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] names = scanner.nextLine().split(" ");
        int hotPotato = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        for (int i = 0; i < names.length; i++) {
            queue.offer(names[i]);
        }

        while (queue.size() > 1) {


            for (int i = 1; i < hotPotato; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int cycle) {
        boolean primeCheck = true;
        if (cycle == 0 || cycle == 1) {
            primeCheck = false;
            return primeCheck;
        } else {
            for (int i = 2; i <= Math.sqrt(cycle); i++) {
                if (cycle % i == 0) {
                    primeCheck = false;
                }
            }
        }
        return primeCheck;
    }
}
