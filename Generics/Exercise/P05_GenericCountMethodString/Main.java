package Generics.Exercise.P05_GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            box.add(input);
        }

       String compare = scanner.nextLine();
      int counter = box.compareTo(compare);
        System.out.println(counter);
    }
}
