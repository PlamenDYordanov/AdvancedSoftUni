package Advanced.Generics.Exercise.P01_GenericBox;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> stringBox = new Box<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            stringBox.add(input);
        }
        System.out.println(stringBox);
    }
}
