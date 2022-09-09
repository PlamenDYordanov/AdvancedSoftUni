package Advanced.FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06_FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");
        int start = Integer.parseInt(range[0]);
        int finish = Integer.parseInt(range[1]);

        String command = scanner.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= finish; i++) {
            list.add(i);
        }
        Predicate<Integer> predicate;
        if (command.equals("even")) {
             predicate = e -> e % 2 == 0;

        } else   {
            predicate = e -> e % 2 != 0;
        }
        list.stream()
                .filter(predicate)
                .forEach(integer -> System.out.printf("%d ",integer));
    }

    }

