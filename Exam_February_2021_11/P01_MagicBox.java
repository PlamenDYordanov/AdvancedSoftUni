package Advanced.Exam_February_2021_11;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        for (int integer : firstBox) {
            firstBoxQueue.offer(integer);
        }
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        for (int integer : secondBox) {
            secondBoxStack.push(integer);
        }
        int totalSum = 0;
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstBoxValue = firstBoxQueue.poll();
            int secondBoxValue = secondBoxStack.pop();
            int sum = firstBoxValue + secondBoxValue;
            if (sum % 2 == 0) {
                totalSum += sum;
            }else {
              firstBoxQueue.addFirst(firstBoxValue);
              firstBoxQueue.addLast(secondBoxValue);
            }
        }
        if (firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }else {
            System.out.println("Second magic box is empty.");
        }
        if (totalSum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d", totalSum);
        }else {
            System.out.printf("Poor prey... Value: %d", totalSum);
        }
    }

}
