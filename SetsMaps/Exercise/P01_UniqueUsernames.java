package Advanced.SetsMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            usernames.add(name);
        }
        for (String username : usernames) {
            System.out.println(username);
        }


    }
}
