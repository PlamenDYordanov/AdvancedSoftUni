package Advanced.Generics.Exercise.P01_GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> list;

    public Box() {
        list = new ArrayList<>();
    }

    public void add(T input) {
        list.add(input);
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        for (T element : list) {
            builder.append(element.getClass().getName() + ": " + element + "\n");
        }
        return builder.toString();
    }
}
