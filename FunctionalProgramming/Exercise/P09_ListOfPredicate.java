package Advanced.FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P09_ListOfPredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> number = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            number.add(i);
        }
        List<Integer> divisibleNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        BiPredicate<Integer, List<Integer>> filter = (integer, divisible) -> {
            for (Integer divisibleNumber : divisible) {
                if (integer % divisibleNumber != 0) {
                    return false;
                }
            }
            return true;
        };

        List<Integer> listNumber = number.stream()
                .filter(integer -> filter.test(integer, divisibleNumbers)).collect(Collectors.toList());
        for (Integer integer : listNumber) {
            System.out.print(integer + " ");
        }


    }
}




