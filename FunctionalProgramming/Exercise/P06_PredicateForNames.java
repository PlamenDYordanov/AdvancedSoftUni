package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class P06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int requireLength = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        BiPredicate<String, Integer> predicate = (strings, integer) -> {
           boolean isEnoughLength = strings.length()<=integer;
            if (isEnoughLength) {
                return true;
            }else {
                return false;
            }
        };
      names =  names.stream()
                .filter(name -> predicate.test(name,requireLength)).collect(Collectors.toList());
        for (String name : names) {
            System.out.println(name);
        }
    }
}
