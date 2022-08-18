package Advanced.Stack_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")){

            if (input.equals("back")){
                if (stack.size()>1){
                   stack.poll();
                    System.out.println(stack.peek());
                }else {
                    System.out.println("no previous URLs");
                }

            }else {
                stack.push(input);
                System.out.println(input);
            }


            input = scanner.nextLine();
        }
    }
}
