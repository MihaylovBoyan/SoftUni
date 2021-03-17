package Basics;

import java.util.Scanner;

public class histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double under200Counter = 0;
        double bween200and399Counter = 0;
        double bween400and599Counter = 0;
        double bween600and799Counter = 0;
        double over800Counter = 0;

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            if (number < 200) {
                under200Counter++;
            } else if (number >= 200 && number < 400) {
                bween200and399Counter++;
            } else if (number >= 400 && number <= 599) {
                bween400and599Counter++;
            } else if (number >= 600 && number <= 799) {
                bween600and799Counter++;
            } else if (number >= 800) {
                over800Counter++;
            }
        }
        double p1 = under200Counter / n * 100;
        double p2 = bween200and399Counter / n * 100;
        double p3 = bween400and599Counter / n * 100;
        double p4 = bween600and799Counter / n * 100;
        double p5 = over800Counter / n * 100;
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n",p1,p2,p3,p4,p5);


    }
}
