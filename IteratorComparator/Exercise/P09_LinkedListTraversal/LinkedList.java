package Advanced.IteratorComparator.Exercise.P09_LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T>/* implements Iterable<T>*/ {

    private List<T> list;

    public LinkedList() {
        this.list = new ArrayList<>();
    }

    public void Add(T number) {
       this.list.add(number);
    }

    public boolean Remove(T number) {
        return this.list.remove(number);
    }

    public int getSize() {
        return  list.size();
    }

    /*@Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }*/

    public List<T> getList() {
        return list;
    }
}
