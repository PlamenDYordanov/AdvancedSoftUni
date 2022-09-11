package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> getMinNum = array -> Arrays.stream(array).map(x -> x).min().getAsInt();
        Function<int[], Integer> getMin = integers -> {
            int min = Integer.MAX_VALUE;
            for (Integer integer : integers) {
                if (integer < min){
                    min = integer;
                }
            }
            return min;
        };

        System.out.println(getMin.apply(numbers));
    }
}
