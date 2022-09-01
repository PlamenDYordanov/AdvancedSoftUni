package Advanced.SetsMaps.Exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> mapOfCards = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.endsWith("JOKER")) {
            String name = input.split("\\: ")[0];
            String cards = input.split("\\: ")[1];
            String[] card = cards.split(", ");
            if (!mapOfCards.containsKey(name)) {
                mapOfCards.put(name, new LinkedHashSet<>());
            }
            for (String curCard : card) {
                mapOfCards.get(name).add(curCard);
            }

            input = scanner.nextLine();
        }

        mapOfCards(mapOfCards);

    }

    private static void mapOfCards( Map<String, Set<String>> mapOfCards) {

        Map<String, Integer> pointsMap = new HashMap<>();
        pointsMap.put("2", 2);
        pointsMap.put("3", 3);
        pointsMap.put("4", 4);
        pointsMap.put("5", 5);
        pointsMap.put("6", 6);
        pointsMap.put("7", 7);
        pointsMap.put("8", 8);
        pointsMap.put("9", 9);
        pointsMap.put("J", 11);
        pointsMap.put("Q", 12);
        pointsMap.put("K", 13);
        pointsMap.put("A", 14);

        for (Map.Entry<String, Set<String>> entry : mapOfCards.entrySet()) {
            AtomicInteger sum = new AtomicInteger();
            System.out.print(entry.getKey() + ": ");
            entry.getValue().stream()
                    .forEach(e -> {
                        String firstSymbol = String.valueOf(e.charAt(0));
                        if (pointsMap.containsKey(firstSymbol)) {
                            int currentPower = pointsMap.get(firstSymbol);
                            if (e.endsWith("H")) {
                                sum.addAndGet(currentPower * 3);
                            } else if (e.endsWith("S")) {
                                sum.addAndGet(currentPower * 4);
                            } else if (e.endsWith("D")) {
                                sum.addAndGet(currentPower * 2);
                            } else if (e.endsWith("C")) {
                                sum.addAndGet(currentPower);
                            }
                        } else {
                            if (e.endsWith("H")) {
                                sum.addAndGet(10 * 3);
                            } else if (e.endsWith("S")) {
                                sum.addAndGet(10 * 4);
                            } else if (e.endsWith("D")) {
                                sum.addAndGet(10 * 2);
                            } else if (e.endsWith("C")) {
                                sum.addAndGet(10);
                            }
                        }
                    });
            System.out.println(sum);
        }


    }
}
