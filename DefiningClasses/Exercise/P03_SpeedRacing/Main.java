package Advanced.DefiningClasses.Exercise.P03_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, RacingCar> carMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        RacingCar racingCar = null;
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String model = inputLine[0];
            double fuelAmount = Double.parseDouble(inputLine[1]);
            double fuelCost = Double.parseDouble(inputLine[2]);

            racingCar = new RacingCar(model, fuelAmount, fuelCost, 0.0);
            carMap.putIfAbsent(model, racingCar);

        }
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")) {
            String model = commandLine.split("\\s+")[1];
            double travelDistance = Double.parseDouble(commandLine.split("\\s+")[2]);
            racingCar = carMap.get(model);
            if (racingCar.calculation(travelDistance)) {
                racingCar.setFuelAmount(racingCar.getFuelAmount() - travelDistance * racingCar.getFuelCost());
                double currentDistance = racingCar.getDistanceTravel();
                racingCar.setDistanceTravel(travelDistance+currentDistance);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            commandLine = scanner.nextLine();
        }

        carMap.entrySet()
                .stream()
                .forEach(print -> System.out.printf("%s %.2f %.0f%n", print.getValue().getModel(),print.getValue().getFuelAmount(),print.getValue().getDistanceTravel()));

    }
}
