package Advanced.IteratorComparator.Exercise.P06_StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class ComparatorName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result = Integer.compare(first.getLengthName(),second.getLengthName());
        if (result == 0){
            result = first.getName().toUpperCase().compareTo(second.getName().toUpperCase());
        }
        return result;
    }
}
