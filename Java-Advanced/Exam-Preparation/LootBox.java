package ExamPreparation;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class LootBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> claimedItems = new ArrayList<>();


        int[] firstBox = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondBox = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int box : secondBox) {
            stack.push(box);
        }

        for (int box : firstBox) {
            queue.offer(box);
        }


        while (!(stack.isEmpty() || queue.isEmpty())) {

            int firstNum = stack.peek();
            int secondNum = queue.peek();
            int sum = firstNum + secondNum;
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                stack.pop();
                queue.poll();

            } else {
                queue.offerLast(stack.pop());
            }


        }

        int sum = 0;
        for (Integer item : claimedItems) {
            sum += item;
        }

        if (stack.isEmpty()) {
            System.out.println("Second lootbox is empty");
            if (sum < 100) {
                System.out.printf("Your loot was poor... Value: %d", sum);
            } else {
                System.out.printf("Your loot was epic! Value: %d", sum);
            }

        } else {
            System.out.println("First lootbox is empty");
            if (sum < 100) {
                System.out.printf("Your loot was poor... Value: %d", sum);
            } else {
                System.out.printf("Your loot was epic! Value: %d", sum);
            }

        }


    }


}
