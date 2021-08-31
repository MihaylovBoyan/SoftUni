package harvestingFields;

import harvestingFields.RichSoil.RichSoilLand;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        String input = scanner.nextLine();

        while (!input.equals("HARVEST")) {

            switch (input) {
                case "private" -> findFieldsByType(declaredFields, sb, "private");
                case "protected" -> findFieldsByType(declaredFields, sb, "protected");
                case "public" -> findFieldsByType(declaredFields, sb, "public");
                case "all" -> findFieldsByType(declaredFields, sb, "p");
            }


            input = scanner.nextLine();
        }
        System.out.println(sb);

    }

    private static void findFieldsByType(Field[] declaredFields, StringBuilder sb, String modifier) {
        Arrays.stream(declaredFields)
                .filter(d -> Modifier.toString(d.getModifiers()).contains(modifier))
                .forEach(field -> {
                    sb.append(String.format("%s %s %s%n", Modifier.toString(field.getModifiers()),
                            field.getType().getSimpleName(), field.getName()));
                });
    }
}
