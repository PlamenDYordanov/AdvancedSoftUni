package Advanced.SetsMaps.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .sorted((e1,e2) -> e2.compareTo(e1))
                .limit(3)
                .collect(Collectors.toList());

        integers.forEach(p ->{
            System.out.print(p+" ");
        });
    }
}
