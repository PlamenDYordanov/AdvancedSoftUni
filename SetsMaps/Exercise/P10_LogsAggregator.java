package Advanced.SetsMaps.Exercise;

import java.util.*;

public class P10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int users = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> namesIps = new TreeMap<>();
        Map<String, Integer> nameDuration = new TreeMap<>();
        for (int i = 0; i < users; i++) {
            String[] userData = scanner.nextLine().split("\\s+");
            boolean isIpExist = false;
            String name = userData[1];
            int duration = Integer.parseInt(userData[2]);
            String ip = userData[0];
            namesIps.putIfAbsent(name, new ArrayList<>());
            nameDuration.putIfAbsent(name, 0);
            nameDuration.put(name, nameDuration.get(name) + duration);
            for (Map.Entry<String, List<String>> entry : namesIps.entrySet()) {
                if (entry.getKey().equals(name)) {
                    if (entry.getValue().size() == 0) {
                        entry.getValue().add(ip);
                    } else {
                        for (String curIp : entry.getValue()) {
                            if (curIp.equals(ip)) {
                                isIpExist = true;
                                break;
                            }
                        }
                        if (!isIpExist) {
                            namesIps.get(name).add(ip);
                        }
                    }
                }
            }
        }
        List<Integer> valuesOfDuration = new ArrayList<>(nameDuration.values());
        int index = 0;
        for (Map.Entry<String, List<String>> entry : namesIps.entrySet()) {
            Collections.sort(entry.getValue());
            System.out.printf("%s: %d " + "[" + String.join(", ", entry.getValue()) + "]" + System.lineSeparator(), entry.getKey(), valuesOfDuration.get(index));
            index++;
        }

    }
}
