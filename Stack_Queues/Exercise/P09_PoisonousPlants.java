package Advanced.Stack_Queues.Exercise;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P09_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] plantsPesticide = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> newStack = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i : plantsPesticide) {
            stack.push(i);
        }
        int days = 0;
        int first = 0;
        boolean isRemoved = false;
        while (!isRemoved) {


            isRemoved = true;
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                //Check last plant. If аll is dead till now(newStack == 0).
                if (i == size - 1 && newStack.size() == 0){
                    int lastInt = stack.pop();

                    if (lastInt >= first) {
                        newStack.push(first);
                    } else {
                        isRemoved = false;
                    }
                    break;
                }
                //Check last plant. If we have survived(newStack != 0).

                if (i == size - 1 && newStack.size() != 0) {
                    int lastInt = newStack.peek();
                    first = stack.pop();
                    //Everytime we push last from the stack to newStack because is first in our "plantsPesticide" array. So there is nothing to its left.
                    if (lastInt <= first) {
                        newStack.push(first);
                    } else {
                        newStack.push(first);
                        isRemoved = false;
                    }
                    break;
                }
                //Check pesticide amount:
                //if left side plant has less pesticide right die (left is "second")
                first = stack.pop();
                int second = stack.peek();

                if (first <= second) {
                    newStack.push(first);
                } else {
                    isRemoved = false;

                }

            }
            days++;
            //Fill stack with survived plants
            while (!newStack.isEmpty()) {
                stack.push(newStack.poll());
            }


        }
        System.out.println(days - 1);
    }
}
