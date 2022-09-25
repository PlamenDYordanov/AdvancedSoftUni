package Generics.Exercise.P08P09_CunstomList_Sort;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements  Iterable {

    private List<T> customList;


    public CustomList(){
        this.customList = new ArrayList<>();
    }

    public void add(T element){
        this.customList.add(element);
    }
    public T remove(int index){
       return this.customList.remove(index);
    }
    public boolean contains(T element){
       return this.customList.contains(element);
    }
    public void swapIndex(int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && secondIndex <= this.customList.size() - 1) {
            T firstElement = this.customList.get(firstIndex);
            T secondElement = this.customList.get(secondIndex);
            this.customList.set(firstIndex, secondElement);
            this.customList.set(secondIndex, firstElement);
        }
    }
    public int compareTo(T compare) {
        int counter = 0;
        for (T element : this.customList) {
            if (element.compareTo(compare) > 0) {
                counter++;
            }
        }
        return counter;
    }
    public T getMax(){
    return     this.customList.stream()
                .max(Comparator.naturalOrder()).get();
    }
    public T getMin(){
        return     this.customList.stream()
                .min((e1,e2) -> e1.compareTo(e2)).get();
    }

    public void print(){
        for (T element : this.customList) {
            System.out.println(element);
        }


    }
    public void sort(){
       this.customList.sort((e1,e2)->e1.compareTo(e2));
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        for (T element : this.customList) {
            action.accept(element);
        }
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
