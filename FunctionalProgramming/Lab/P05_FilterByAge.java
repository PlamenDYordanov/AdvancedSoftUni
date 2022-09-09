package Advanced.FunctionalProgramming.Lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class P05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> personsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split(", ");
            String name = inputLine[0];
            int age = Integer.parseInt(inputLine[1]);
            personsMap.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        //PREDICATE
        BiPredicate<Integer, Integer> predicate;
        if (condition.equals("older")) {
            predicate = (personAge, ageLimit) -> personAge >= age;
        } else {

            predicate = (personAge, ageLimit) -> personAge <= age;
        }
        //CONSUMER
        Consumer<Map.Entry<String,Integer>> consumer;

        if (format.equals("name")){
            consumer = person -> System.out.println(person.getKey());
        }else if (format.equals("age")){
            consumer = person -> System.out.println(person.getValue());
        }else {
         consumer = person ->   System.out.printf("%s - %d%n",person.getKey(), person.getValue());
        }
        personsMap.entrySet()
                .stream()
                .filter(person ->predicate.test(person.getValue(),age))
                .forEach(consumer);

    }


}

