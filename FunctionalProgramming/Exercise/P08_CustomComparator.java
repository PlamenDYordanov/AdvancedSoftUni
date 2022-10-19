package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] number = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator  = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0){
                return -1;
            }else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            }else {
                return num1.compareTo(num2);
            }
        };
        Arrays.sort(number, comparator);
        Arrays.stream(number).forEach(print -> System.out.print(print + " "));

    }
}
