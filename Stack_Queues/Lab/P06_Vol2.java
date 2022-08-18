package Advanced.Stack_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_Vol2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < children.length; i++) {
            String currentName = children[i];
            queue.offer(currentName);
        }

        while (queue.size()!=1){
            for (int i = 0; i < passes-1; i++) {
                String currChild = queue.poll();
               queue.offer(currChild);
            }
            System.out.printf("Removed %s%n", queue.poll());
        }
        System.out.printf("Last is %s%n",queue.peek());
    }
}
