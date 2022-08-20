package Advanced.Stack_Queues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");


        for (String s : input) {
            char symbol = s.charAt(0);
            //if digit - offer
            if (Character.isDigit(symbol)) {
                queue.offer(s);
                //if alphabet  - offer
            } else if (symbol >= 65 && symbol <= 90 || symbol>= 97 && symbol <=122) {
                queue.offer(s);
                //check precedence of symbols
            } else if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else {

                    stack.push(getInformationAfterSymbol(symbol, s, stack, queue));

                }
                //bracket rule
            } else if (symbol == '(' || symbol == ')') {
                stack.push(s);
                if (symbol == '(' && stack.contains(")")) {
                    String currentPop = stack.pop();
                    while (!currentPop.equals("(")) {
                        queue.offer(stack.pop());
                        currentPop = stack.peek();

                    }
                    stack.pop();

                } else if (symbol == ')' && stack.contains("(")) {

                    String currentPop = stack.pop();
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        queue.offer(stack.pop());
                    } else {
                        while (!currentPop.equals("(")) {
                            queue.offer(stack.pop());
                            currentPop = stack.peek();

                        }
                        stack.pop();
                    }

                }
            }

        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        System.out.print(String.join(" ", queue));


    }


    private static String getInformationAfterSymbol(char symbol, String s, ArrayDeque<String> stack, ArrayDeque<String> queue) {
        String currSymbol = stack.peek();
        if (symbol == '+') {
            if (currSymbol.equals("-")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("*")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("/")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("+")) {
                queue.offer(stack.pop());
            }
        } else if (symbol == '-') {
            if (currSymbol.equals("-")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("*")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("/")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("+")) {
                queue.offer(stack.pop());
            }
        } else if (symbol == '*') {
            if (currSymbol.equals("*")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("/")) {
                queue.offer(stack.pop());
            }
        } else {
            if (currSymbol.equals("*")) {
                queue.offer(stack.pop());
            } else if (currSymbol.equals("/")) {
                queue.offer(stack.pop());
            }
        }
        return s;

    }

}
