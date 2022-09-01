package Advanced.SetsMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        int firstSet = Integer.parseInt(dimension[0]);
        int secondSet = Integer.parseInt(dimension[0]);

        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();

        for (int i = 0; i < firstSet; i++) {
            String number = scanner.nextLine();
            first.add(number);
        }
        for (int i = 0; i < secondSet; i++) {
            String number = scanner.nextLine();
            second.add(number);
        }

        for (String s : first) {
            if (second.contains(s)) {
                System.out.print(s + " ");
            }
        }

    }
}
