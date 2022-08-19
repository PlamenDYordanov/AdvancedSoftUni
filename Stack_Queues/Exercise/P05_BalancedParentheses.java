package Advanced.Stack_Queues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> brackets = new ArrayDeque<>();

        boolean isBalanced = true;
        
        if (input.length() % 2 != 0) {
            isBalanced = false;
        } else {
            for (int i = 0; i < input.length(); i++) {
                char currentSymbol = input.charAt(i);

                if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {

                    brackets.push(currentSymbol);

                } else if (currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']') {
                    if (!brackets.isEmpty()) {
                        char currPop = brackets.pop();
                        if (currPop == '(') {
                            if (currentSymbol != ')') {
                                isBalanced = false;
                                break;
                            }
                        } else if (currPop == '{') {
                            if (currentSymbol != '}') {
                                isBalanced = false;
                                break;
                            }
                        } else if (currPop == '[') {
                            if (currentSymbol != ']') {
                                isBalanced = false;
                                break;
                            }

                        }


                    }
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
