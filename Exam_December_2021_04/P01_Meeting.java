package Advanced.Exam_December_2021_04;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] maleValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] femaleValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        for (int maleValue : maleValues) {
            maleStack.push(maleValue);
        }
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        for (int femaleValue : femaleValues) {
            femaleQueue.offer(femaleValue);
        }
        int matches = 0;
        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int currentMaleValue = maleStack.pop();
            int currentFemaleValue = femaleQueue.poll();

            if (currentFemaleValue % 25 != 0 && currentFemaleValue > 0 && currentMaleValue % 25 != 0 && currentMaleValue > 0) {
                if (currentFemaleValue == currentMaleValue) {
                    matches++;
                } else {
                    maleStack.push(currentMaleValue - 2);
                }
                continue;
            }

            //Check zero
            if (currentFemaleValue <= 0) {
                maleStack.push(currentMaleValue);
                if (femaleQueue.isEmpty()) {
                    break;
                }
                continue;
            }
            if (currentMaleValue <= 0) {
                femaleQueue.addFirst(currentFemaleValue);
                if (maleStack.isEmpty()) {
                    break;
                }
                continue;
            }
            if (currentFemaleValue % 25 == 0) {
                maleStack.push(currentMaleValue);
                if (femaleQueue.size() > 0) {
                    femaleQueue.poll();
                    continue;
                } else {
                    break;
                }
            } else {
                femaleQueue.addFirst(currentFemaleValue);
                if (maleStack.size() > 0) {
                    maleStack.pop();
                    continue;
                } else {
                    break;
                }
            }

        }
        System.out.printf("Matches: %d%n", matches);

        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String[] male = new String[maleStack.size()];
            int size = maleStack.size();
            for (int i = 0; i < size; i++) {
                male[i] = String.valueOf(maleStack.pop());
            }
            System.out.print("Males left: ");
            System.out.println(String.join(", ", male));
        }

        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String[] female = new String[femaleQueue.size()];
            int size = femaleQueue.size();
            for (int i = 0; i < size; i++) {
                female[i] = String.valueOf(femaleQueue.poll());
            }
            System.out.print("Females left: ");
            System.out.println(String.join(", ", female));
        }
    }
}
