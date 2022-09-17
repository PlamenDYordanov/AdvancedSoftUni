package Advanced.DefiningClasses.Exercise.P05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engines = Integer.parseInt(scanner.nextLine());
        Engine engine;
        Car car;
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < engines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            String displacements = "n/a";
            String efficiency = "n/a";
            if (tokens.length == 4) {
                efficiency = tokens[3];
                displacements = tokens[2];
            } else if (tokens.length == 3) {
                char firstChar = tokens[2].charAt(0);
                if (Character.isDigit(firstChar)) {
                    displacements = tokens[2];
                    efficiency = "n/a";
                } else {
                    displacements = "n/a";
                    efficiency = tokens[2];
                }
            }
            engine = new Engine(model, power, displacements, efficiency);
            engineList.add(engine);

        }
        int carInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carInputs; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];
            String engineModel = tokens[1];
            String weight = "n/a";
            String color = "n/a";
            if (tokens.length == 4) {
                weight = tokens[2];
                color = tokens[3];
            } else if (tokens.length == 3) {
                char fistChar = tokens[2].charAt(0);
                if (Character.isDigit(fistChar)) {
                    weight = tokens[2];
                } else {
                    color = tokens[2];
                }
            }

            car = new Car(carModel, engineModel, weight, color);
            carList.add(car);
        }
        for (Car curCar : carList) {
            String currentEngine = curCar.getEngineModel();
            for (Engine curEngine : engineList) {
                if (curEngine.getModel().equals(currentEngine)) {
                    System.out.print(String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n", curCar.getModel(), curCar.getEngineModel(), curEngine.getPower(), curEngine.getDisplacement(), curEngine.getEfficiency()
                            , curCar.getWeight(), curCar.getColor()));
                }
            }
        }
    }
}
