package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> func = e -> Integer.parseInt(e);
        Function <Integer, String> func2 = integer -> integer.toString();

        List<String> number = Arrays.stream(scanner.nextLine().split(", "))
                .map(func)
                .filter(integer -> integer % 2 == 0)
                .map(func2)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", number));
        number = number
                .stream().map(func)
                .sorted((left, right) -> {
                    int result = left.compareTo(right);
                    return result;
                }).map(func2)
                .collect(Collectors.toList());
        System.out.println(String.join(", ",number));


    }
}
