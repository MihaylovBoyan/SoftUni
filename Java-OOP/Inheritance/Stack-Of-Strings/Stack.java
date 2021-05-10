package Inheritance;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<String> data;


    public Stack() {
        this.data = new ArrayList<>();
    }

    public void push(String str) {
        this.data.add(str);
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        } else {
            return data.get(data.size() - 1);
        }
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            return data.remove(data.size() - 1);
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

}
