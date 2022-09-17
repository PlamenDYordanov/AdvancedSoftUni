package Advanced.DefiningClasses.Exercise.P01_OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> listOfPersons = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        Person person;
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            person = new Person(name, age);
            listOfPersons.add(person);

        }
        listOfPersons = listOfPersons.stream().filter(age -> age.getAge() > 30)
                .sorted(((o1, o2) -> {
                    return o1.getName().compareTo(o2.getName());
                }))
                .collect(Collectors.toList());

        for (Person person1 : listOfPersons) {
            System.out.printf("%s - %d%n", person1.getName(), person1.getAge());
        }

    }
}
