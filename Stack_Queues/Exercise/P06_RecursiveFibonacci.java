package Advanced.Stack_Queues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.offer(1L);
        queue.offer(1L);
        long sum = 0;
        for (int i = 0; i < n ; i++) {
            long firstNumber = queue.poll();
            long secondNumber = queue.peek();

            queue.offer((firstNumber+secondNumber));
        }
        if (n <= 1) {
            System.out.println(1);
        } else {
            System.out.println(queue.peek());
        }
    }
}
