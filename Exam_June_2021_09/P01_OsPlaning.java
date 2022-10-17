package Advanced.Exam_June_2021_09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_OsPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] taskArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] threadsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int requireTask = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();
        for (int integer : taskArr) {
            taskStack.push(integer);
        }
        for (int integer : threadsArr) {
            threadQueue.offer(integer);
        }
        int currentThread = 0;
        int currentTask = 0;
        while (true) {
            currentThread = threadQueue.poll();
            currentTask = taskStack.pop();
            if (currentThread >= currentTask && currentTask != requireTask) {
                continue;
            }
            if (currentTask == requireTask) {
                threadQueue.addFirst(currentThread);
                break;
            } else {
                taskStack.push(currentTask);

            }
        }
        System.out.printf("Thread with value %d killed task %d%n", currentThread, currentTask);
        int size = threadQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.print(threadQueue.poll() + " ");
        }
    }
}
