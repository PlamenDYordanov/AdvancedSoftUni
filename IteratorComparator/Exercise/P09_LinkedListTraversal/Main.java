package Advanced.IteratorComparator.Exercise.P09_LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String command = inputLine[0];
            int number = Integer.parseInt(inputLine[1]);

            switch (command){
                case "Add":
                    linkedList.Add(number);
                    break;
                case "Remove":
                    linkedList.Remove(number);
                    break;
            }

        }
        System.out.println(linkedList.getSize());

        for (Integer integer : linkedList.getList()) {
            System.out.print(integer + " ");
        }
    }
}
