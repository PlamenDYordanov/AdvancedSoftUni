package Advanced.Stack_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07_MathPotatoVol2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> children = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        String removedChildren = "";
        int cycle = 0;
        int index = 0;
        boolean isGetIndexFormPrime = false;
        while (children.size() > 1) {
            cycle++;
            if (index == children.size()) {
                index = children.size() - 1;
            } else if (index > 0 && !isGetIndexFormPrime) {
                index--;
            }
            isGetIndexFormPrime = false;
            for (int j = 1; j <= passes; j++) {

                removedChildren = children.get(index);
                if (isPrime(cycle) && j == passes) {
                    index = children.indexOf(removedChildren);
                    isGetIndexFormPrime = true;
                    continue;
                } else if (index >= children.size() - 1) {
                    index = 0;
                    continue;
                }
                index++;

            }
            if (!isPrime(cycle)) {
                queue.offer("Removed " + removedChildren);
                children.remove(removedChildren);
            } else {
                queue.offer("Prime " + removedChildren);
            }


        }

        while (!queue.isEmpty()) {
            System.out.println(queue.pollFirst());
        }

        for (String child : children) {
            System.out.printf("Last is %s%n", child);
        }


    }

    public static boolean isPrime(int n) {
        if (n <=1){
            return false;
        }
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }
}

