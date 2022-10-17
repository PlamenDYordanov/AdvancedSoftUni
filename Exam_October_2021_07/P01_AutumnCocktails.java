package Advanced.Exam_October_2021_07;

import java.util.*;

public class P01_AutumnCocktails {
    private static boolean isPearSour = false;
    private static boolean isTheHarvest = false;
    private static boolean isAppleHinny = false;
    private static boolean isHighFashion = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] freshnessArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        for (int integer : ingredientsArr) {
            ingredientsQueue.offer(integer);
        }
        for (int integer : freshnessArr) {
            freshnessStack.push(integer);
        }

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int currentIngredient = ingredientsQueue.poll();
            int currentFreshness = freshnessStack.pop();
            if (currentIngredient == 0) {
                freshnessStack.addFirst(currentFreshness);
                continue;
            }
            int currentMix = currentFreshness * currentIngredient;
            if (currentMix == 150) {
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                isPearSour = true;
            } else if (currentMix == 250) {
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                isTheHarvest = true;
            } else if (currentMix == 300) {
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                isAppleHinny = true;
            } else if (currentMix == 400) {
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                isHighFashion = true;
            } else {
                ingredientsQueue.addLast(currentIngredient + 5);
            }


        }
        if (isPearSour && isTheHarvest && isAppleHinny && isHighFashion) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientsQueue.isEmpty()) {
            int sum = ingredientsQueue.stream().mapToInt(x -> x).sum();
            System.out.printf("Ingredients left: %d%n", sum);
        }
        cocktails.entrySet()
                .stream()
                .filter(value -> value.getValue() > 0)
                .forEach(print -> System.out.printf("# %s --> %d%n", print.getKey(), print.getValue()));
    }
}
