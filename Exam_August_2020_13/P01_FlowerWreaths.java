package Advanced.Exam_August_2020_13;

import java.util.*;

public class P01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] liliesArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] rosesArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        for (int integer : liliesArr) {
            liliesStack.push(integer);
        }
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        for (int integer : rosesArr) {
            rosesQueue.offer(integer);
        }
        int totalWreath = 0;
        List<Integer> store = new ArrayList<>();
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int currentLilies = liliesStack.pop();
            int currentRoses = rosesQueue.poll();
            int sum = currentLilies + currentRoses;
            if (sum == 15) {
                totalWreath++;
            } else if (sum > 15) {
                while (sum > 15) {
                    currentLilies -= 2;
                    sum = currentRoses + currentLilies;
                }
                if (sum == 15){
                    totalWreath ++;
                }else {
                    store.add(currentLilies);
                    store.add(currentRoses);
                }
            } else {
                store.add(currentLilies);
                store.add(currentRoses);
            }
        }
        int totalStore = store.stream().mapToInt(x -> x).sum();
        if (totalStore / 15 > 0) {
            totalWreath += totalStore / 15;
        }
        if (totalWreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", totalWreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - totalWreath);
        }
    }
}
