package Advanced.Stack_Queues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02_BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        int pushNumbers = numbers[0];
        int popNumbers = numbers[1];
        int number = numbers[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < pushNumbers; i++) {
            int digit = scanner.nextInt();
            stack.push(digit);
        }
        for (int i = 0; i < popNumbers; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int minNumber = Integer.MAX_VALUE;
            boolean flag = true;
            for (Integer integer : stack) {
                if (integer < minNumber) {
                    minNumber = integer;
                }
                if (integer == number) {
                    System.out.println("true");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(minNumber);
            }
        }

    }
}
