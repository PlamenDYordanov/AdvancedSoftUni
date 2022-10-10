package Advanced.Exam_AprilRetake_2022_02;

import java.util.*;

public class P01_Blacksmith {
    static final int GLADIUS = 70;
    static final int SHAMSHIR = 80;
    static final int KATANA = 90;
    static final int SABRE = 110;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] steelArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] carbonArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queueSteel = new ArrayDeque<>();
        for (int integer : steelArr) {
            queueSteel.offer(integer);
        }
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        for (int integer : carbonArr) {
            carbonStack.push(integer);
        }
        Map<String, Integer> swordsMap = new HashMap<>();
        swordsMap.put("Gladius", 0);
        swordsMap.put("Katana", 0);
        swordsMap.put("Shamshir", 0);
        swordsMap.put("Sabre", 0);

        while (!queueSteel.isEmpty() && !carbonStack.isEmpty()) {
            int currentSteelValue = queueSteel.poll();
            int currentCarbonValue = carbonStack.pop();
            int sum = currentCarbonValue + currentSteelValue;

            if (sum == GLADIUS) {
                int currentValue = swordsMap.get("Gladius");
                swordsMap.put("Gladius", currentValue + 1);
            } else if (sum == SHAMSHIR) {
                int currentValue = swordsMap.get("Shamshir");
                swordsMap.put("Shamshir", currentValue + 1);
            } else if (sum == KATANA) {
                int currentValue = swordsMap.get("Katana");
                swordsMap.put("Katana", currentValue + 1);
            } else if (sum == SABRE) {
                int currentValue = swordsMap.get("Sabre");
                swordsMap.put("Sabre", currentValue + 1);
            } else {

                carbonStack.push(currentCarbonValue + 5);
            }


        }
        int totalSwords = swordsMap.values().stream().mapToInt(i -> i).sum();
        if (totalSwords > 0) {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (!queueSteel.isEmpty()) {
        List<String> steel = new ArrayList<>();
            for (Integer integer : queueSteel) {
                steel.add(String.valueOf(integer));
            }
            System.out.println(String.join(", ", steel));
        } else {
            System.out.println("Steel left: none");
        }
        if (!carbonStack.isEmpty()) {
            System.out.print("Carbon left: ");
           List<String> carbon = new ArrayList<>();
            for (Integer integer : carbonStack) {
                carbon.add(String.valueOf(integer));
            }
            System.out.println(String.join(", ",carbon));
        } else {
            System.out.println("Carbon left: none");
        }
        if (totalSwords > 0) {
            swordsMap.entrySet()
                    .stream()
                    .sorted((left, right) -> {
                        int result = left.getKey().compareTo(right.getKey());
                        return result;
                    }).forEach(e ->
                    {
                        if (e.getValue() != 0) {
                            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
                        }
                    });
        }

    }
}
