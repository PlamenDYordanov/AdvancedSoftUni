package Advanced.SetsMaps.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();
        Map<String, Integer> junks = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        boolean isOver = false;

        while (!isOver) {
            String input = scanner.nextLine();
            List<String> inputList = Arrays.stream(input.split(" ")).collect(Collectors.toList());


            for (int i = 0; i < inputList.size(); i += 2) {
                int valueOfMat = Integer.parseInt(inputList.get(i));
                String material = inputList.get(i + 1).toLowerCase();

                if (material.equals("shards") || material.equals("motes") || material.equals("fragments")) {

                    int currentValue = materials.get(material);
                    materials.put(material, currentValue + valueOfMat);

                    if (materials.get(material) >= 250) {
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        } else {
                            System.out.println("Valanyr obtained!");
                        }
                        materials.put(material, materials.get(material) - 250);
                        isOver = true;
                        break;
                    }
                } else {

                    if (!junks.containsKey(material)) {
                        junks.put(material, valueOfMat);
                    } else {
                        int currentValue = junks.get(material);
                        junks.put(material, currentValue + valueOfMat);
                    }

                }
            }

        }
        materials.entrySet().stream()
                .sorted(((o1, o2) -> {
                    int result = o2.getValue().compareTo(o1.getValue());
                    if (result == 0){
                        result = o1.getKey().compareTo(o2.getKey());
                    }
                        return result;
                })).forEach(print -> {
                    System.out.printf("%s: %d%n", print.getKey(), print.getValue());
                });


       /* materials.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));*/
        junks.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
