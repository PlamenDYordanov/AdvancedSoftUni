package Advanced.Stack_Queues.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> children = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        int passes = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        String removedChildren = "";
        int index = 0;
        while (children.size() > 1) {
            if (index == children.size()) {
                index = children.size()-1;
            }else if (index>0){
                index--;
            }
            for (int j = 0; j < passes; j++) {

                removedChildren = children.get(index);

                if (index >= children.size() - 1) {
                    index = 0;
                    continue;
                }
                index++;

            }
            queue.offer(removedChildren);
            children.remove(removedChildren);

        }

        while (!queue.isEmpty()){
            System.out.printf("Removed %s%n",queue.pollFirst());
        }
        for (String child : children) {
            System.out.printf("Last is %s%n", child);
        }


    }
}
