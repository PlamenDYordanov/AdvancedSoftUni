package Advanced.Exam_August_2022_01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_Kat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] arrLicensePlate = Arrays.stream(scanner.nextLine().split(", ")).mapToLong(Long::parseLong).toArray();
        long[] arrCars = Arrays.stream(scanner.nextLine().split(", ")).mapToLong(Long::parseLong).toArray();

        ArrayDeque<Long> licensePlate = new ArrayDeque<>();
        ArrayDeque<Long> cars = new ArrayDeque<>();
        for (long plate : arrLicensePlate) {
            licensePlate.offer(plate);
        }
        for (long car : arrCars) {
            cars.push(car);
        }

        long totalRegCars = 0;
        long days = 0;
        long currentCarsPush = 0;
        while (!cars.isEmpty() && !licensePlate.isEmpty()) {
            days++;
            long currentPlates = licensePlate.poll();
            long currentCars = cars.pop();

            if (currentPlates / 2 > currentCars) {
                currentPlates = currentPlates - (currentCars * 2);
                licensePlate.offer(currentPlates);
            } else if (currentPlates / 2 < currentCars) {
                currentCarsPush = currentCars - (currentPlates / 2);
                currentCars = currentPlates / 2;
                cars.addLast(currentCarsPush);
            }
            totalRegCars += currentCars;
        }
        System.out.printf("%d cars were registered for %d days!%n", totalRegCars, days);
        if (cars.isEmpty() && licensePlate.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (cars.isEmpty()) {
            long sum = licensePlate.stream().mapToLong(x -> x).sum();
            System.out.printf("%d license plates remain!%n", sum);
        } else if (licensePlate.isEmpty()) {
            long sum = cars.stream().mapToLong(x -> x).sum();
            System.out.printf("%d cars remain without license plates!%n", sum);
        }
    }
}
