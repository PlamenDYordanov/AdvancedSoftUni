package Advanced.Stack_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();




        while (!input.equals("Home")){
                switch (input){

                    case "back":
                        if (stack.size()<=1){
                            System.out.println("no previous URLs");
                        }else {
                            queue.addFirst(stack.poll());
                            System.out.println(stack.peek());


                        }

                        break;
                    case "forward":
                        if (queue.isEmpty()){
                            System.out.println("no next URLs");
                            queue.clear();
                        }else {
                            stack.push(queue.peek());
                            System.out.println( queue.pop());
                        }
                        break;
                    default:{
                        stack.push(input);
                        System.out.println(input);
                        queue.clear();
                    }

                }



            input = scanner.nextLine();
        }

    }
}
