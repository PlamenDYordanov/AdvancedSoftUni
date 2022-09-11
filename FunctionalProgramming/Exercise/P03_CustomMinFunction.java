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
        Function<int[], Integer> getMinNum = array -> Arrays.stream(array).map(x->x).min().getAsInt();

        System.out.println(getMinNum.apply(numbers));
    }
}
