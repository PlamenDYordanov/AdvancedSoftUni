package Advanced.SetsMaps.Exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> mapOfUsers = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] messageArr = input.split("\\s+");
            String ip = messageArr[0].split("=")[1];
            String message = messageArr[1].split("=")[1];
            String userName = messageArr[2].split("=")[1];

            if (!mapOfUsers.containsKey(userName)) {
                mapOfUsers.put(userName, new LinkedHashMap<>());
                mapOfUsers.get(userName).put(ip, new ArrayList<>());
                mapOfUsers.get(userName).get(ip).add(message);
            } else {
                if (!mapOfUsers.get(userName).containsKey(ip)) {
                    mapOfUsers.get(userName).put(ip, new ArrayList<>());
                    mapOfUsers.get(userName).get(ip).add(message);
                } else {
                    mapOfUsers.get(userName).get(ip).add(message);
                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, List<String>>> entry : mapOfUsers.entrySet()) {
            final int[] counter = {1};
            System.out.printf("%s:%n", entry.getKey());
            entry.getValue().entrySet().stream()
                    .forEach(p -> {
                        int i = counter[0]++;
                        if (entry.getValue().size() == i) {
                            System.out.printf("%s => %d.%n", p.getKey(), p.getValue().size());
                        } else {
                            System.out.printf("%s => %d, ", p.getKey(), p.getValue().size());
                        }
                    });

        }

    }
}
