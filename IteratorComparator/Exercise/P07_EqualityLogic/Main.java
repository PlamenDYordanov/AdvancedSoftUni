package Advanced.IteratorComparator.Exercise.P07_EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> treeSet = new TreeSet<>(new ComparatorByName());
        HashSet<Person> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            Person person = new Person(name, age);
            treeSet.add(person);
            hashSet.add(person);
        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
