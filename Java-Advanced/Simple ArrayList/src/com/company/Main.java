package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        DynamicArray<Integer> array = new DynamicArrayImpl<Integer>();
        array.add(2);
        array.add(4);
        array.add(6);
        array.add(8);

        System.out.println(array.get(1));
        array.set(1, 5);
        System.out.println(array.get(1));

        array.remove(1);
        System.out.println(array.get(1));

        ArrayList<Integer> integers = new ArrayList<>();

    }
}
