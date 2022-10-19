package Generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T number) {
        list.add(number);
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        for (T element: list) {
            builder.append(element.getClass().getName()).append(": ").append(element).append("\n");
        }

        return builder.toString();
    }
}
