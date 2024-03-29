package Advanced.IteratorComparator.Exercise.P01_ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private List<String> list;
    private static int index = 0;

    public ListyIterator(List<String> list) {
        this.list = new ArrayList<>();
    }

    public void setList(List<String> list) {
        this.list = list;
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                if (index < list.size() - 1) {
                    return true;
                }
                return false;
            }
            @Override
            public String next() {
                if (hasNext()) {
                    index++;
                    return "true";
                } else {
                    return "false";
                }
            }
        };
    }

    public void PrintElement() {
        if (list.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.list.get(index));
        }
    }
}
