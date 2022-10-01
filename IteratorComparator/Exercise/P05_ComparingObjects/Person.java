package Advanced.IteratorComparator.Exercise.P05_ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private String town;
    private int age;

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {

         int  result = this.getName().compareTo(person.getName());
            if (result == 0) {
                result = Integer.compare(this.getAge(), person.getAge());
            }
            if (result == 0) {
                result = this.getTown().compareTo(person.getTown());
            }


        return result;
    }



}
