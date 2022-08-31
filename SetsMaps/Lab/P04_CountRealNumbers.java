package Advanced.SetsMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] number = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(e -> Double.parseDouble(e))
                .toArray();
        Map<Double, Integer> mapCounter = new LinkedHashMap<>();

        for (double v : number) {
            if (!mapCounter.containsKey(v)) {
                mapCounter.put(v, 1);
            } else {
                int currentCount = mapCounter.get(v);
                mapCounter.put(v, currentCount + 1);
            }
        }
        mapCounter.entrySet().forEach(p -> System.out.printf("%.1f -> %d%n",p.getKey(), p.getValue()));
    }}
