package Advanced.Stack_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();
        if (number == 0) {
            System.out.println(0);
        } else {
            while (number != 0) {
                int leftOver = number % 2;
                binaryNum.push(leftOver);
                number = number / 2;

            }
        }
        for (Integer integer : binaryNum) {
            System.out.print(integer);
        }

    }
}
