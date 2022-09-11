package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> func = integers -> {
            int min = integers.stream().mapToInt(value -> value).min().getAsInt();
            int index = integers.lastIndexOf(min);
                return index;
        };

        System.out.println(func.apply(numbers));
    }
}
