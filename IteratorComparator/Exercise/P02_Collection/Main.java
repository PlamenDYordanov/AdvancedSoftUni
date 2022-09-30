package Advanced.IteratorComparator.Exercise.P02_Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        List<String> create = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(create);
        listyIterator.setList(create);
        String input = scanner.nextLine();

        while (!input.equals("END")){

            switch (input){
                case "Move":

                        System.out.println(listyIterator.iterator().next());

                    break;
                case "Print":
                    listyIterator.PrintElement();
                    break;
                case "HasNext":
                    if (listyIterator.iterator().hasNext()){
                        System.out.println("true");
                    }else {
                        System.out.println("false");
                    }
                    break;
                case "PrintAll":
                    listyIterator.forEach(print -> System.out.print(print + " "));
                    System.out.println();
                    break;

            }


            input = scanner.nextLine();
        }
    }
}
