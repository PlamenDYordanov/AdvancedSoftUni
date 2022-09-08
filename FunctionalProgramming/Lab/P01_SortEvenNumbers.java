package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> number = Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> Integer.parseInt(e))
                .filter(integer -> integer % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", number));
        number = number
                .stream().map(e -> Integer.parseInt(e))
                .sorted((left, right) -> {
                    int result = left.compareTo(right);
                    return result;
                }).map(integer -> integer.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ",number));


    }
}
