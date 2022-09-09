package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<Double, Double> func = e -> e * 1.2;
        UnaryOperator<Double> func2 = e -> e * 1.2;
        List<Double> list = Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> Double.parseDouble(e))
                .map(func2)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        for (Double number : list) {
            System.out.printf("%.2f%n", number);
        }
    }
}
