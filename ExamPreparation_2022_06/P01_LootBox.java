package Advanced.ExamPreparation_2022_06;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLootBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] secondLootBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        for (int integer : firstLootBox) {
            firstBox.offer(integer);
        }
        for (int integer : secondLootBox) {
            secondBox.push(integer);
        }
        int collection = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int firstBoxCurr = firstBox.poll();
            int secondBoxCur = secondBox.pop();
            int sum = firstBoxCurr + secondBoxCur;
            if (sum % 2 == 0 ){
                collection += sum;
            }else {
                firstBox.addFirst(firstBoxCurr);
                firstBox.addLast(secondBoxCur);
            }
        }
        if (firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }
        if (collection >= 100){
            System.out.printf("Your loot was epic! Value: %d%n",collection);
        }else {
            System.out.printf("Your loot was poor... Value: %d%n",collection);
        }
    }
}
