package Advanced.IteratorComparator.Exercise.P06_StrategyPattern;

public class Person  {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getLengthName(){
        return getName().length();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
