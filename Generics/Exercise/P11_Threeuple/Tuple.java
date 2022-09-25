package Generics.Exercise.P11_Threeuple;

import java.util.ArrayList;
import java.util.List;

public class Tuple<T> {

    private List<T> itemOne;
    private List<T> itemTwo;
    private List<T> itemThree;

    public Tuple() {
        this.itemOne = new ArrayList<>();
        this.itemTwo = new ArrayList<>();
        this.itemThree = new ArrayList<>();
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
        System.out.print("-> ");
        for (T itemThree : itemThree) {
            System.out.print(itemThree + " ");
        }
        System.out.println();
    }

    public void clear() {
        this.itemTwo.clear();
        this.itemOne.clear();
        this.itemThree.clear();
    }

    public List<T> getItemThree() {
        return itemThree;
    }

    public boolean drunkOrNot(String drunkOrNot) {
        if (drunkOrNot.equals("drunk")){
            return true;
        }
        return false;
    }
}
