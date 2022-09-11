package Advanced.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());


        Collections.reverse(numbers);

        int divisibleInt = Integer.parseInt(scanner.nextLine());
        //take list return list after division
        Function<List<Integer>, List<Integer>> func = integers -> {
            integers.removeIf(element -> element % divisibleInt == 0);
            return integers;
        };
        //print number from list
        Consumer<List<Integer>> printNumbers = print -> print.stream()
                .forEach(p -> System.out.print(p + " "));

        numbers = func.apply(numbers);
        printNumbers.accept(numbers);


    }
}
