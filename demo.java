package Advanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> milligramsOfCaffeine = new ArrayDeque<>();

        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        String input = scanner.nextLine();
        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(milligramsOfCaffeine::push);

        input = scanner.nextLine();
        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int mg = 0;
        while (!milligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()) {

            int currentEnergy = energyDrinks.peek();
            int currentMg = milligramsOfCaffeine.peek();
            if (currentEnergy * currentMg <= 300 - mg) {
                mg += currentEnergy * currentMg;
            } else {
                energyDrinks.offer(currentEnergy);
                mg -= 30;
                if (mg < 0) {
                    mg = 0;
                }
            }

        }
        if (!energyDrinks.isEmpty()) {
            for (Integer integer : energyDrinks) {
                System.out.println("Drinks left: " + energyDrinks.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d caffeine.", mg);
    }
}

