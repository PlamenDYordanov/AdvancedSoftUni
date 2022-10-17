package Advanced.Exam_August_2021_08;

import java.util.*;

public class P01_PastryShop {
    private static boolean isBiscuit = false;
    private static boolean isCake = false;
    private static boolean isPastry = false;
    private static boolean isPie = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] liquidArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        Map<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);
        for (int integer : liquidArr) {
            liquidQueue.offer(integer);
        }
        for (int integer : ingredientsArr) {
            ingredientStack.push(integer);
        }

        while (!ingredientStack.isEmpty() && !liquidQueue.isEmpty()) {
            int currentLiquid = liquidQueue.poll();
            int currentIngredient = ingredientStack.pop();
            int sum = currentIngredient + currentLiquid;
            if (sum == 25) {
                food.put("Biscuit", food.get("Biscuit") + 1);
                isBiscuit = true;
            } else if (sum == 50) {
                isCake = true;
                food.put("Cake", food.get("Cake") + 1);
            } else if (sum == 75) {
                isPastry = true;
                food.put("Pastry", food.get("Pastry") + 1);
            } else if (sum == 100) {
                isPie = true;
                food.put("Pie", food.get("Pie") + 1);
            } else {
                ingredientStack.push(currentIngredient + 3);
            }
        }
        if (isBiscuit && isCake && isPastry && isPie){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            List<String> liquid = new ArrayList<>();
            System.out.print("Liquids left: ");
            for (Integer integer : liquidQueue) {
                liquid.add(String.valueOf(integer));
            }
            System.out.print(String.join(", ", liquid));
            System.out.println();
        }
        if (ingredientStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            List<String> ingredient = new ArrayList<>();
            System.out.print("Ingredients left: ");
            for (Integer integer : ingredientStack) {
                ingredient.add(String.valueOf(integer));
            }
            System.out.print(String.join(", ", ingredient));
            System.out.println();
        }

        food.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
