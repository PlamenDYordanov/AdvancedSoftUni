package Advanced.IteratorComparator.Exercise.P03_StackIterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Stack implements Iterable<Integer> {
    ArrayDeque<Integer> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }


    public void push(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            this.stack.push(elements[i]);
        }
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            System.out.println("No elements");
            return;
        }
        this.stack.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private ArrayDeque<Integer> tempStack = new ArrayDeque<>(stack);

            @Override
            public boolean hasNext() {
                return !tempStack.isEmpty();
            }

            @Override
            public Integer next() {
                return tempStack.pop();
            }
        };
    }

}
