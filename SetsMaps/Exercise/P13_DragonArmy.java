package Advanced.SetsMaps.Exercise;

import java.util.*;

public class P13_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<Double>>> dragonMap = new LinkedHashMap<>();
        Map<String, List<Double>> totalPoints = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            String damage = input[2];
            String health = input[3];
            String armor = input[4];
            double damageInt = 0;
            double healthInt = 0;
            double armorInt = 0;

            if (damage.contains("null")) {
                damageInt = 45;
            } else {
                damageInt = Double.parseDouble(input[2]);
            }
            if (health.contains("null")) {
                healthInt = 250;
            } else {
                healthInt = Double.parseDouble(input[3]);

            }
            if (armor.contains("null")) {
                armorInt = 10;
            } else {
                armorInt = Double.parseDouble(input[4]);

            }

            if (dragonMap.containsKey(type) && dragonMap.get(type).containsKey(name)) {
                dragonMap.get(type).get(name).set(0, damageInt);
                dragonMap.get(type).get(name).set(1, healthInt);
                dragonMap.get(type).get(name).set(2, armorInt);
            } else {
                dragonMap.putIfAbsent(type, new LinkedHashMap<>());
                dragonMap.get(type).putIfAbsent(name, new ArrayList<>());
                dragonMap.get(type).get(name).add(0, damageInt);
                dragonMap.get(type).get(name).add(1, healthInt);
                dragonMap.get(type).get(name).add(2, armorInt);

            }

        }

        Map<String, List<Double>> newMap = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, List<Double>>> entry : dragonMap.entrySet()) {
            newMap = entry.getValue();
            int index = 0;
            for (Map.Entry<String, List<Double>> subEntry : newMap.entrySet()) {
                if (index > 0) {
                    double currentDamage = totalPoints.get(entry.getKey()).get(0);
                    double currentHeath = totalPoints.get(entry.getKey()).get(1);
                    double currentArmor = totalPoints.get(entry.getKey()).get(2);
                    totalPoints.get(entry.getKey()).set(0, currentDamage + subEntry.getValue().get(0));
                    totalPoints.get(entry.getKey()).set(1, currentHeath + subEntry.getValue().get(1));
                    totalPoints.get(entry.getKey()).set(2, currentArmor + subEntry.getValue().get(2));
                } else {
                    for (int i = 0; i < subEntry.getValue().size(); i++) {
                        totalPoints.putIfAbsent(entry.getKey(), new ArrayList<>());
                        totalPoints.get(entry.getKey()).add(subEntry.getValue().get(i));
                    }
                }
                index++;

            }


        }
        List<Integer> indexs = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<Double>>> entry : dragonMap.entrySet()) {
            indexs.add(entry.getValue().size());
        }
        int index = 0;
        for (Map.Entry<String, List<Double>> entry : totalPoints.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {

                double currentValue = entry.getValue().get(i);
                entry.getValue().set(i, currentValue / indexs.get(index));
            }
            index++;

        }
        for (Map.Entry<String, Map<String, List<Double>>> mapEntry : dragonMap.entrySet()) {

            totalPoints.entrySet().stream().limit(1).forEach(o -> {

                System.out.printf("%s::(%.2f/%.2f/%.2f)%n", o.getKey(), o.getValue().get(0), o.getValue().get(1), o.getValue().get(2));
            });

            mapEntry.getValue().entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        int result = e1.getKey().compareTo(e2.getKey());
                        return result;
                    }).forEach(p -> {
                        double currentDamage = p.getValue().get(0);
                        double currentHealth = p.getValue().get(1);
                        double currentArmor = p.getValue().get(2);
                        System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", p.getKey(), currentDamage, currentHealth, currentArmor);

                    });
            totalPoints.remove(mapEntry.getKey());
        }

       /* for (Map.Entry<String, List<Double>> entry : totalPoints.entrySet()) {
            String currentType = entry.getKey();
            double damage = entry.getValue().get(0);
            double health = entry.getValue().get(1);
            double armor = entry.getValue().get(2);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", currentType, damage, health, armor);


            dragonMap.entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        e1.getValue().entrySet()
                                .stream()
                                .sorted((p1, p2) -> {
                                    int result = p2.getKey().compareTo(p1.getKey());
                                    if (result == 0) {
                                        result = p1.getKey().compareTo(p2.getKey());
                                    }
                                    return result;
                                });

                    });

            int indexDiff = 0;
            for (Map.Entry<String, Map<String, List<Double>>> subEntry : dragonMap.entrySet()) {
                String[] arr = subEntry.getValue().toString().replace("{", "").split("\\],");
                boolean isFinish = false;
                String arrNames = arr[indexDiff].split("=")[0].trim();
                dragonMap.entrySet().forEach(p -> {
                    subEntry.getValue().entrySet().stream()
                            .sorted((e1, e2) -> {
                                int result = e2.getKey().compareTo(e1.getKey());
                                return result;

                            }).forEach((o -> {
                                double currentDamage = o.getValue().get(0);
                                double currentHealth = o.getValue().get(1);
                                double currentArmor = o.getValue().get(2);
                                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", arrNames, currentDamage, currentHealth, currentArmor);


                            }));
                });

                indexDiff++;


                isFinish = true;

                if (isFinish) {
                    dragonMap.remove(entry.getKey());
                    break;
                }


            }

            System.out.printf("");*/
    }
}
