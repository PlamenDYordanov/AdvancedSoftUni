package Advanced.SetsMaps.Lab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> studentGrade = new TreeMap<>();
        for (int i = 0; i < countOfStudents; i++) {
            String name = scanner.nextLine();
            String[] score = scanner.nextLine().split(" ");
            Double[] grade = new Double[score.length];
            for (int j = 0; j < score.length; j++) {
                grade[j] = Double.parseDouble(score[j]);
            }

            if (!studentGrade.containsKey(name)) {
                studentGrade.put(name, grade);
            }


        }

        studentGrade.values().stream().forEach(print -> {

            BigDecimal df = BigDecimal.ZERO;
            for (Double aDouble : print) {
               df = df.add(BigDecimal.valueOf(aDouble));

                }
            DecimalFormat dff = new DecimalFormat("0.###########");
                BigDecimal result = df.divide(BigDecimal.valueOf(print.length));

            });

    }
}
