package Advanced.Exam_April_2021_10;

import java.util.*;

public class P01_Bouquets {
    private static int bouquetCounter;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tulipsArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        for (int integer : tulipsArr) {
            tulipsStack.push(integer);
        }
        ArrayDeque<Integer> queueDaffodils = new ArrayDeque<>();
        for (int integer : daffodils) {
            queueDaffodils.offer(integer);
        }
        List<Integer> store = new ArrayList<>();
        while (!tulipsStack.isEmpty() && !queueDaffodils.isEmpty()) {
            int currentTulip = tulipsStack.pop();
            int currentDaffodils = queueDaffodils.poll();
            int sum = currentDaffodils + currentTulip;
            if (sum == 15) {
                bouquetCounter++;
            } else if (sum < 15) {
                store.add(currentDaffodils);
                store.add(currentTulip);
            } else {
                while (sum > 15) {
                    currentTulip -= 2;
                    sum = currentDaffodils + currentTulip;
                }
                if (sum == 15) {
                    bouquetCounter++;
                } else {
                    store.add(currentDaffodils);
                    store.add(currentTulip);
                }


            }
        }
        int sumLeftovers = store.stream().mapToInt(x -> x).sum();
        int bouquetsForLeftFlower = sumLeftovers / 15;
        if (bouquetsForLeftFlower >= 1) {
            bouquetCounter += bouquetsForLeftFlower;
        }
        if (bouquetCounter >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetCounter);
        }else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetCounter);
        }
    }
}
