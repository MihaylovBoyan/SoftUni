package blackBoxInteger;

import blackBoxInteger.BlackBoxInt.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        while (!input.equals("END")) {

            String[] tokens = input.split("_");
            String action = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            if (action.equals("add")) {
                invokeMethod(blackBoxInt, methods, number, "add");
            } else if (action.equals("subtract")) {
                invokeMethod(blackBoxInt, methods, number, "subtract");
            } else if (action.equals("divide")) {
                invokeMethod(blackBoxInt, methods, number, "divide");
            } else if (action.equals("multiply")) {
                invokeMethod(blackBoxInt, methods, number, "multiply");
            } else if (action.equals("rightShift")) {
                invokeMethod(blackBoxInt, methods, number, "rightShift");
            } else if (action.equals("leftShift")) {
                invokeMethod(blackBoxInt, methods, number, "leftShift");
            }
            input = scanner.nextLine();
        }

    }

    private static void invokeMethod(BlackBoxInt blackBoxInt, Method[] methods, int number, String command) throws IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Method method = Arrays.stream(methods).filter(m -> m.getName().equals(command)).findFirst().orElseThrow(null);
        method.setAccessible(true);
        method.invoke(blackBoxInt, number);
        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        System.out.println(innerValue.getInt(blackBoxInt));
    }

}

