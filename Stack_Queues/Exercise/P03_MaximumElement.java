package Advanced.Stack_Queues.Exercise;


import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    int number = Integer.parseInt(command[1]);
                    stack.push(number);
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "3":
                    if (!stack.isEmpty()) {
                        int max = Integer.MIN_VALUE;
                        for (Integer integer : stack) {
                            if (integer > max) {
                                max = integer;
                            }
                        }
                        System.out.println(max);
                    }
                    break;
            }

        }

    }
}
