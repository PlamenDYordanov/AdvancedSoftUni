package Generics.Exercise.P05_GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> list;

    public Box() {
        list = new ArrayList<>();
    }

    public void add(T input) {
        this.list.add(input);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && secondIndex <= this.list.size() - 1) {
            T firstElement = this.list.get(firstIndex);
            T secondElement = this.list.get(secondIndex);
            this.list.set(firstIndex, secondElement);
            this.list.set(secondIndex, firstElement);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : this.list) {
            builder.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return builder.toString();
    }

    public int compareTo(T compare) {
        int counter = 0;
        for (T element : this.list) {
            if (element.compareTo(compare) > 0) {
                counter++;
            }
        }
        return counter;
    }
}
