package Advanced.SetsMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P05_AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> mapOfStudents = new TreeMap<>();

        for (int i = 0; i < students; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            String name = inputLine[0];
            double grade = Double.parseDouble(inputLine[1]);

            if (!mapOfStudents.containsKey(name)) {
                mapOfStudents.put(name, new ArrayList<>());
                mapOfStudents.get(name).add(grade);
            } else {
                mapOfStudents.get(name).add(grade);
            }
        }
     /*   for (Map.Entry<String, List<Double>> entry : mapOfStudents.entrySet()) {
            double averageGrades = entry.getValue().stream().mapToDouble(x ->x).average().getAsDouble();
            System.out.printf("%s -> ",entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("%.2f ",entry.getValue().get(i));
            }
            System.out.printf("(avg: %.2f)%n",averageGrades);
        }*/
        mapOfStudents.entrySet()
                .stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                    double avgSum = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", avgSum);
                });

    }
}
