package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<String, Integer> function = n -> Integer.parseInt(n);


        List<String> number = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        System.out.printf("Count = %d%n", number.size());

     int sum = number.stream().mapToInt(value -> Integer.parseInt(value)).sum();
        System.out.println("Sum = "+sum);

    }
}
