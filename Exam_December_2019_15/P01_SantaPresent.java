package Advanced.Exam_December_2019_15;

import java.util.*;
import java.util.stream.Collectors;

public class P01_SantaPresent {
    private static int doll = 150;
    private static int woodenTrain = 250;
    private static int teddyBear = 300;
    private static int bicycle = 400;
    private static boolean isDoll = false;
    private static boolean isTrain = false;
    private static boolean isTeddyBear = false;
    private static boolean isBicycle = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] materialsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] magicArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> materialStack = new ArrayDeque<>();
        for (int integer : materialsArr) {
            materialStack.push(integer);
        }
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
        for (int integer : magicArr) {
            magicQueue.offer(integer);
        }
        Map<String, Integer> present = new TreeMap<>();
        present.put("Doll", 0);
        present.put("Wooden train", 0);
        present.put("Teddy bear", 0);
        present.put("Bicycle", 0);
        while (!materialStack.isEmpty() && !magicQueue.isEmpty()) {
            int currentMagic = magicQueue.poll();
            int currentMaterial = materialStack.pop();
            if (currentMagic == 0 && currentMaterial == 0) {
                continue;
            }else if (currentMagic == 0){
                materialStack.push(currentMaterial);
                continue;
            }else if (currentMaterial == 0){
                magicQueue.addFirst(currentMagic);
                continue;
            }
            int multiplication = currentMagic * currentMaterial;
            if (multiplication < 0) {
                int sum = currentMagic + currentMaterial;
                materialStack.push(sum);
                continue;
            }
            if (multiplication == doll) {
                present.put("Doll", present.get("Doll") + 1);
                isDoll = true;
            } else if (multiplication == woodenTrain) {
                present.put("Wooden train", present.get("Wooden train") + 1);
                isTrain = true;
            } else if (multiplication == teddyBear) {
                present.put("Teddy bear", present.get("Teddy bear") + 1);
                isTeddyBear = true;
            } else if (multiplication == bicycle) {
                present.put("Bicycle", present.get("Bicycle") + 1);
                isBicycle = true;
            } else {
                materialStack.push(currentMaterial + 15);
            }
        }
        if (isTeddyBear && isBicycle || isDoll && isTrain) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialStack.isEmpty()) {
            List<String> materialList = new ArrayList<>();
            for (Integer integer : materialStack) {
                materialList.add(String.valueOf(integer));
            }
            System.out.println("Materials left: " + materialStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!magicQueue.isEmpty()) {
            List<String> magicList = new ArrayList<>();
            for (Integer integer : materialStack) {
                magicList.add(String.valueOf(integer));
            }
            System.out.println("Magic left: " + magicQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        present.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf("%s: %d%n", key, value);
            }
        });

    }
}
