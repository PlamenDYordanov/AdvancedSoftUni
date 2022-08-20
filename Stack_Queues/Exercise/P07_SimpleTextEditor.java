package Advanced.Stack_Queues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");

            switch (commandLine[0]) {
                case "1":
                    stack.push(String.valueOf(text));
                    text.append(commandLine[1]);
                    break;
                case "2":
                    stack.push(String.valueOf(text));
                    int countIndex = Integer.parseInt(commandLine[1]);

                    int firstIndex = text.length() - countIndex;
                    if (countIndex<= text.length()) {
                        text.delete(firstIndex, firstIndex + countIndex);
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(commandLine[1]);
                    if (index - 1 >= 0 && index <= text.length()) {
                        char symbol = text.charAt(index - 1);
                        System.out.println(symbol);
                    }
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                      text = new StringBuilder(stack.pop());

                    }
                    break;

            }
        }
    }
}
