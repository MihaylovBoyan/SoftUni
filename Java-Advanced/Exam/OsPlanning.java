package MatriciSViktor;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();


        int[] tasksData = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[] threadsData = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        for (int task : tasksData) {
            tasks.push(task);
        }

        for (int thread : threadsData) {
            threads.offer(thread);
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());

        int killedTask = 0;
        int threadKiller = 0;

        while (tasks.contains(taskToKill)){

            if (threads.peek() >= tasks.peek()){
               killedTask = tasks.peek();
                tasks.pop(); //peek 20
                threadKiller = threads.poll();

            } else {
                killedTask = tasks.peek();
                threadKiller = threads.peek();
                threads.poll(); //20 pee
                if(tasks.peek() == taskToKill){
                    break;
                }

            }

        }

        System.out.printf("Thread with value %d killed task %d%n", threadKiller, killedTask);
        System.out.print(threadKiller + " ");
        for (Integer thread : threads) {
            System.out.print(thread + " ");
        }



    }
}
