package Advanced.IteratorComparator.Exercise.P04_Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Lake lake = new Lake();

        while (!input.equals("END")){
            int[] integer = Arrays.stream(input.split(", "))
                    .mapToInt((Integer::parseInt))
                    .toArray();
            lake.addIntegers(integer);

            input = scanner.nextLine();
        }
        List<String> result = new ArrayList<>();
        for (Integer integer : lake) {
            result.add(String.valueOf(integer));
        }
        System.out.println(String.join(", ", result));
    }
}
