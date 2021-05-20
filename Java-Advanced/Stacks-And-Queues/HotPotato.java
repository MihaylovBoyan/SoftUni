package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();


        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }

        while (queue.size() > 1){

            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());

        }

        System.out.println("Last is " + queue.poll());

    }
}
