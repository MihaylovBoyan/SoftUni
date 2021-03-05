package Basics.Projects;

import java.util.Scanner;

public class Projects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int numberProjects = Integer.parseInt(scanner.nextLine());
        int singleProjectTime = 3;
        int timeNeeded = numberProjects * singleProjectTime;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, timeNeeded, numberProjects);
    }
}
