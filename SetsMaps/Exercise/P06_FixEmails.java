package Advanced.SetsMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> mapOfEmails = new LinkedHashMap<>();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            mapOfEmails.put(name, email);
            name = scanner.nextLine();

        }
        for (Map.Entry<String, String> entry : mapOfEmails.entrySet()) {
            String currentEmail = entry.getValue();
            if (!currentEmail.endsWith("us") && !currentEmail.endsWith("uk") && !currentEmail.endsWith("com")) {
                System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
            }

        }

    }

}
