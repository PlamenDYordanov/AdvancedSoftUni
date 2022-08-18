package Advanced.Stack_Queues.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.addAll(list);

        int totalPoints = 0;
        while (stack.size()>1){
            int firstNum = Integer.parseInt(stack.poll());
            String addOrSubtract = stack.poll();
            int secondNum = Integer.parseInt(stack.pop());

            if (addOrSubtract.equals("+")){
               totalPoints = firstNum+secondNum;

                stack.push(String.valueOf(totalPoints));

            }else {
                totalPoints = firstNum-secondNum;
                stack.push(String.valueOf(totalPoints));
            }



        }
        System.out.println(totalPoints);
    }
}
