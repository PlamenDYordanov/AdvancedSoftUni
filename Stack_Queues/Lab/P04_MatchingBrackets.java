package Advanced.Stack_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length() ; i++) {
            char currChar = input.charAt(i);

            if (currChar == '('){
                stack.push(i);
            }else if (currChar == ')'){
                int startIndex = stack.pop();
                String contest = input.substring(startIndex, i+1);
                System.out.println(contest);
            }
        }
    }
}
