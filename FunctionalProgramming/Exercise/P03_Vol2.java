package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03_Vol2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> getMinNum = listNum -> Collections.min(listNum);
        System.out.println(getMinNum.apply(list));
    }
}


