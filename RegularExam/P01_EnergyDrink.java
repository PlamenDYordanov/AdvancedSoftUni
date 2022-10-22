package Advanced.RegularExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_EnergyDrink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] caffeineArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] energyDrinksArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int stamantCaffeine = 0;
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinkQueue = new ArrayDeque<>();

        for (int integer : energyDrinksArr) {
            energyDrinkQueue.offer(integer);
        }
        for (int integer : caffeineArr) {
            caffeineStack.push(integer);
        }

        while (!energyDrinkQueue.isEmpty() && !caffeineStack.isEmpty()) {
            int currentCaffeine = caffeineStack.pop();
            int currentEnergyDrink = energyDrinkQueue.poll();

            int multiply = currentCaffeine * currentEnergyDrink;
            if (multiply <= 300 && stamantCaffeine + multiply <= 300) {
                stamantCaffeine += multiply;

            } else {
                energyDrinkQueue.addLast(currentEnergyDrink);
                if (stamantCaffeine - 30 >= 0) {
                    stamantCaffeine -= 30;
                }

            }


        }
        if (!energyDrinkQueue.isEmpty()) {
            System.out.println("Drinks left: " + energyDrinkQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamantCaffeine);

    }

}
