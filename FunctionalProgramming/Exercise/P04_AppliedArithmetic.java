package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = getNewNumbers -> {
            getNewNumbers = getNewNumbers.stream().map(e -> e += 1).collect(Collectors.toList());
            return getNewNumbers;
        };
        Function<List<Integer>, List<Integer>> multiply = getNewNumbers -> {
            getNewNumbers = getNewNumbers.stream().map(e -> e * 2).collect(Collectors.toList());
            return getNewNumbers;
        };
        Function<List<Integer>, List<Integer>> subtract = getNewNumbers -> {
            getNewNumbers = getNewNumbers.stream().map(e -> e -= 1).collect(Collectors.toList());
            return getNewNumbers;
        };
        Consumer<List<Integer>> printNumbers = print ->
                print.stream()
                        .forEach(p -> System.out.print(p + " "));


        String input = scanner.nextLine();
        while (!input.equals("end")) {

            switch (input) {

                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printNumbers.accept(numbers);
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }


}
