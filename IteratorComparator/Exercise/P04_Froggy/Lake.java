package Advanced.IteratorComparator.Exercise.P04_Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> jumps;

    public Lake() {
        this.jumps = new ArrayList<>();
    }


    public void addIntegers(int[] integer) {
        for (int i = 0; i < integer.length; i++) {
            jumps.add(integer[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }


    public class Frog implements Iterator<Integer> {
        private int index = 0;
        boolean isFinishFirstRound = false;

        @Override
        public boolean hasNext() {
            return index < jumps.size();
        }

        @Override
        public Integer next() {
            int numberToReturn = jumps.get(index);
            index += 2;
            if (index >= jumps.size() && !isFinishFirstRound) {
                isFinishFirstRound = true;
                index = 1;
            }
            return numberToReturn;
        }
    }
}
