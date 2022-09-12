package Advanced.FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P09_Vol2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> number = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            number.add(i);
        }
        List<Integer> DivisibleNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        BiFunction<List<Integer>, List<Integer>, List<Integer>> func = (list, divisible) -> {

            for (int i = 0; i < list.size(); i++) {
                int currentNum = list.get(i);
                int index = list.indexOf(currentNum);

                for (Integer divisibleNum : divisible) {
                    if (currentNum % divisibleNum != 0) {
                        list.remove(index);
                        i--;
                        break;
                    }
                }
            }
            return list;
        };


        number = func.apply(number, DivisibleNumbers);
        for (Integer integer : number) {
            System.out.print(integer + " ");
        }


    }
}
