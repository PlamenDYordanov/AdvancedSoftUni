package Advanced.Exam_December_2020_12;

import java.util.*;

public class P01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> food = new TreeMap<>();
        boolean isBread = false;
        boolean isCake = false;
        boolean isPastry = false;
        boolean isFruitPie = false;
        food.put("Bread", 0);
        food.put("Cake", 0);
        food.put("Fruit Pie", 0);
        food.put("Pastry", 0);
        int[] liquidArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] ingredientArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        for (int integer : liquidArr) {
            liquidQueue.offer(integer);
        }
        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        for (int integer : ingredientArr) {
            ingredientStack.push(integer);
        }
        while (!ingredientStack.isEmpty() && !liquidQueue.isEmpty()) {
            int currLiquid = liquidQueue.poll();
            int currIngredient = ingredientStack.pop();
            int sum = currLiquid + currIngredient;

            if (sum == 25) {
                food.put("Bread", food.get("Bread") + 1);
                isBread = true;
            } else if (sum == 50) {
                food.put("Cake", food.get("Cake") + 1);
                isCake = true;
            } else if (sum == 100) {
                food.put("Fruit Pie", food.get("Fruit Pie") + 1);
                isFruitPie = true;
            } else if (sum == 75) {
                food.put("Pastry", food.get("Pastry") + 1);
                isPastry = true;
            } else {
                ingredientStack.push(currIngredient + 3);
            }
        }
        if (isFruitPie && isBread && isPastry && isCake) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> liquid = new ArrayList<>();
            for (Integer integer : liquidQueue) {
                liquid.add(String.valueOf(integer));
            }
            System.out.print("Liquids left: " + String.join(", ", liquid));
            System.out.println();
        }
        if (ingredientStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> ingredients = new ArrayList<>();
            for (Integer integer : ingredientStack) {
                ingredients.add(String.valueOf(integer));
            }
            System.out.print("Ingredients left: " + String.join(", ", ingredients));
            System.out.println();
        }
        food.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
