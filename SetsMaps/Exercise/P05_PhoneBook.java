package Advanced.SetsMaps.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        Map<String, String> mapOfPhoneNumbers = new HashMap<>();
        while (!inputLine.equals("search")) {

            String name = inputLine.split("-")[0];
            String number = inputLine.split("-")[1];

            mapOfPhoneNumbers.put(name, number);

            inputLine = scanner.nextLine();
        }
        String searchingName = scanner.nextLine();
        while (!searchingName.equals("stop")) {
            if (mapOfPhoneNumbers.containsKey(searchingName)) {
                String phoneNumber = mapOfPhoneNumbers.get(searchingName);

                System.out.printf("%s -> %s%n", searchingName, phoneNumber);
            }else {
                System.out.printf("Contact %s does not exist.%n",searchingName);
            }

            searchingName = scanner.nextLine();
        }


    }
}
