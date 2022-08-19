package Advanced.Stack_Queues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04_BasicQueueOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pushNumbers = numbers[0];
        int pollNumbers = numbers[1];
        int number = numbers[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < pushNumbers; i++) {
            int digit = scanner.nextInt();
            queue.offer(digit);
            
        }
        for (int i = 0; i < pollNumbers; i++) {
            queue.poll();
        }
        if (queue.isEmpty()){
            System.out.println(0);
        }else {
            boolean flag = false;
            int min = Integer.MAX_VALUE;
            for (Integer integer : queue) {
                if (integer == number){
                    System.out.println("true");
                    flag = true;
                    break;
                }else {
                    if (integer<min){
                        min = integer;
                    }
                }
            }
            if (!flag){
                System.out.println(min);
            }

        }
    }
}
