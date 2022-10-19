package Advanced.Exam_June_2020_14;

import java.util.*;

public class P01_Bombs {
    private static int daturaBomb = 40;
    private static int cherryBomb = 60;
    private static int smokeBomb = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bombEffectArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bombCasingArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> effectQueue = new ArrayDeque<>();
        for (int integer : bombEffectArr) {
            effectQueue.offer(integer);
        }
        ArrayDeque<Integer> casingStack = new ArrayDeque<>();
        for (int integer : bombCasingArr) {
            casingStack.push(integer);
        }
        int counterDatura = 0;
        int counterCherry = 0;
        int counterSmoke = 0;
        boolean isCollect = false;
        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Cherry Bombs", 0);
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        while (!effectQueue.isEmpty() && !casingStack.isEmpty()) {
            int currentEffect = effectQueue.poll();
            int currentCasing = casingStack.pop();
            int sum = currentCasing + currentEffect;
            if (sum == daturaBomb) {
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                counterDatura++;
            } else if (sum == cherryBomb) {
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                counterCherry++;
            } else if (sum == smokeBomb) {
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                counterSmoke++;
            } else {
                effectQueue.addFirst(currentEffect);
                casingStack.push(currentCasing - 5);
            }
            if (counterCherry >= 3 && counterSmoke >= 3 && counterDatura >= 3){
                isCollect = true;
                break;
            }
        }
        if (isCollect){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effectQueue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            List<String> bombEffect = new ArrayList<>();
            for (Integer integer : effectQueue) {
                bombEffect.add(String.valueOf(integer));
            }
            System.out.println("Bomb Effects: " + String.join(", ", bombEffect));
        }
        if (casingStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            List<String> bombCasing = new ArrayList<>();
            for (Integer integer : casingStack) {
                bombCasing.add(String.valueOf(integer));
            }
            System.out.println("Bomb Casings: " + String.join(", ", bombCasing));
        }
        bombs.forEach((key, value) -> {System.out.printf("%s: %d%n", key, value);});
    }
}
