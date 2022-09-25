package Generics.Exercise.P10_Tuple;

import java.util.ArrayList;
import java.util.List;

public class Tuple<T> {

    private List<T> itemOne;
    private List<T> itemTwo;

    public Tuple() {
        this.itemOne = new ArrayList<>();
        this.itemTwo = new ArrayList<>();
    }



    public void add(T element, List<T> list) {
        list.add(element);
    }

    public List<T> getItemOne() {
        return itemOne;
    }

    public List<T> getItemTwo() {
        return itemTwo;
    }



    public void print() {
        for (T itemOne : this.itemOne) {
            System.out.print(itemOne + " ");
        }
        System.out.print("-> ");
        for (T itemTwo : this.itemTwo) {
            System.out.print(itemTwo + " ");
        }
        System.out.println();
    }

    public void clear() {
        this.itemTwo.clear();
        this.itemOne.clear();
    }

}
