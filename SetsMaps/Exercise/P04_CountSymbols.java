package Advanced.SetsMaps.Exercise;

import java.util.*;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> characterMap = new TreeMap<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (!characterMap.containsKey(symbol)) {

                characterMap.put(symbol, 1);
            } else {
                int currentCounter = characterMap.get(symbol);
                characterMap.put(symbol, currentCounter + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(),entry.getValue());
        }

    }
}
