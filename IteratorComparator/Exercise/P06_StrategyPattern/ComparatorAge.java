package Advanced.IteratorComparator.Exercise.P06_StrategyPattern;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Person> {


    @Override
    public int compare(Person first, Person second) {
        int result = Integer.compare(first.getAge(),second.getAge());
        return result;
    }
}
