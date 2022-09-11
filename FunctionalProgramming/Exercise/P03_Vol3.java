package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03_Vol3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   /*     Function<Integer[], Integer>   func = integers -> {
            Arrays.stream(integers).mapToInt(Integer::intValue).min();


    };
*/

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value)).min()
                .stream().toArray();
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}

