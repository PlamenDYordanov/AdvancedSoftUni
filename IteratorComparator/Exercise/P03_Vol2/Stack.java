package Advanced.IteratorComparator.Exercise.P03_Vol2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Stack implements Iterable<Integer> {

    private ArrayDeque<Integer> stack;
    private static int index = 0;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private ArrayDeque<Integer> tempStack = new ArrayDeque<>(stack);

            @Override
            public boolean hasNext() {
               if (tempStack.isEmpty()){
                   return false;
               }
               return true;
            }

            @Override
            public Integer next() {
                return tempStack.pop();
            }
        };

    }


    public void pop() {
        if (this.stack.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.stack.poll();
        }
    }

    public void push(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            stack.push(integers.get(i));
        }
    }
}
