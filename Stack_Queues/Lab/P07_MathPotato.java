package Advanced.Stack_Queues.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> children = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < children.size(); i++) {
            String currentName = children.get(i);
            queue.offer(currentName);
        }


        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < passes; i++)
                queue.offer(queue.poll());

            if (isPrime(cycle))
                System.out.println("Prime " + queue.peek());
            else
                System.out.println("Removed " + queue.poll());

            cycle++;
        }
        System.out.println("Last is " + queue.poll());


    }


    public static boolean isPrime(int n) {
            if (n <=1){
                return false;
            }
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }
}

