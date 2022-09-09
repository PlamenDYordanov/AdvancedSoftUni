package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03_CountUppercaseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> predicate = e -> Character.isUpperCase(e.charAt(0));
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }
    }
}
