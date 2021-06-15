package Generics;

import java.lang.reflect.Array;
import java.util.Objects;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T value) {
        return create(value.getClass(), length, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> clazz, int length, T value) {
        T[] arr = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            arr[i] = value;
        }
        return arr;
    }

}
