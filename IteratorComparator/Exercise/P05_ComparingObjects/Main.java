package Advanced.IteratorComparator.Exercise.P05_ComparingObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = null;
        String inputLine = scanner.nextLine();
        List<Person> list = new ArrayList<>();
        while (!inputLine.equals("END")) {
            String name = inputLine.split("\\s+")[0];
            int age = Integer.parseInt(inputLine.split("\\s+")[1]);
            String town = inputLine.split("\\s+")[2];
            person = new Person(name, town, age);

            list.add(person);

            inputLine = scanner.nextLine();
        }
        int sizeOfList = list.size();


        int index = Integer.parseInt(scanner.nextLine());
        Person requirePerson = list.get(index-1);
        list.remove(index - 1);
        int counter = 1;
        for (Person person1 : list) {
            if (person1.compareTo(requirePerson) == 0) {
                counter++;
            }
        }
        if (counter != 1) {
            System.out.printf("%d %d %d", counter, sizeOfList - counter, sizeOfList);
        } else {
            System.out.println("No matches");
        }
    }
}
