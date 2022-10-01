package Advanced.IteratorComparator.Exercise.P06_StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> personSetFirst = new TreeSet<>(new ComparatorName());
        TreeSet<Person> personSetSecond = new TreeSet<>(new ComparatorAge());
        for (int i = 0; i < numberOfPeople; i++) {
            String inputLine = scanner.nextLine();
            String name = inputLine.split("\\s+")[0];
            int age = Integer.parseInt(inputLine.split("\\s+")[1]);
            Person person = new Person(name, age);
            personSetFirst.add(person);
            personSetSecond.add(person);
        }

        for (Person person : personSetFirst) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        for (Person person : personSetSecond) {
            System.out.println(person.getName() + " " + person.getAge());
        }

    }
}
