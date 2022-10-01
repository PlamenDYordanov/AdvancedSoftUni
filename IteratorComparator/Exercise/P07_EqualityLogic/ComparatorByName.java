package Advanced.IteratorComparator.Exercise.P07_EqualityLogic;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result =  first.getName().compareTo(second.getName());
        if (result == 0){
            result = Integer.compare(first.getAge(), second.getAge());
        }
        return result;
    }
}
