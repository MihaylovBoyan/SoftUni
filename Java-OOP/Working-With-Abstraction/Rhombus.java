package abstr;

import java.util.Scanner;
import java.util.function.Predicate;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = readInput();
        String rhombus = buildRhombus(size);
        System.out.println(rhombus);


    }

    private static String buildRhombus(int size) {


        return (printMultipleRows(1, size, +1, size))
                + (printMultipleRows(size - 1, 1, -1, size));


    }

    private static String printLine(int spaces, int stars) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            out.append(" ");
        }

        for (int i = 0; i < stars; i++) {
            out.append("* ");
        }

        return out.toString();
    }

    private static String printMultipleRows(int start, int end, int step, int size) {
        StringBuilder output = new StringBuilder();

        Predicate<Integer> loopCondition = iter -> {
            if (step > 0) {
                return iter <= end;
            }
            return iter >= end;
        };

        for (int r = start; loopCondition.test(r); r += step) {
            output.append(printLine(size - r, r))
                    .append(System.lineSeparator());
        }
        return output.toString();
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
