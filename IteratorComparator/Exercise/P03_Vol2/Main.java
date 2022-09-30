package Advanced.IteratorComparator.Exercise.P03_Vol2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Push":
                    List<Integer> integers = Arrays.stream(input.replace("Push ", "").trim().split(", "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    stack.push(integers);
                    break;
                case "Pop":
                        stack.pop();

                    break;


            }


            input = scanner.nextLine();
        }

        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }

    }


}
