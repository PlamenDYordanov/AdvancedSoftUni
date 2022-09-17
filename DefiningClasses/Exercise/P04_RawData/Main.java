package Advanced.DefiningClasses.Exercise.P04_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Cargo cargo;
        Tire tire;
        Engine engine;
        Car car;
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> tireAge = new ArrayList<>();
            List<Double> tirePressure = new ArrayList<>();
            String[] inputLine = scanner.nextLine().split("\\s+");

            String model = inputLine[0];
            int speed = Integer.parseInt(inputLine[1]);
            int power = Integer.parseInt(inputLine[2]);
            int cargoWeight = Integer.parseInt(inputLine[3]);
            String cargoType = inputLine[4];
            double tirePressure1 = Double.parseDouble(inputLine[5]);
            tirePressure.add(tirePressure1);
            String tireAge1 = inputLine[6];
            tireAge.add(tireAge1);
            double tirePressure2 = Double.parseDouble(inputLine[7]);
            tirePressure.add(tirePressure2);
            String tireAge2 = inputLine[8];
            tireAge.add(tireAge2);
            double tirePressure3 = Double.parseDouble(inputLine[9]);
            tirePressure.add(tirePressure3);
            String tireAge3 = inputLine[10];
            tireAge.add(tireAge3);
            double tirePressure4 = Double.parseDouble(inputLine[11]);
            tirePressure.add(tirePressure4);
            String tireAge4 = inputLine[12];
            tireAge.add(tireAge4);
            cargo = new Cargo(cargoType, cargoWeight);
            tire = new Tire(tireAge, tirePressure);
            engine = new Engine(speed, power);
            car = new Car(model, cargo, engine, tire);
            carList.add(car);


        }
        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car car1 : carList) {
                if (car1.getCargo().getTypeCargo().equals("fragile")) {
                    boolean isLowerThan1 = false;
                    for (Double pressure : car1.getTire().getTirePressure()) {
                        if (pressure < 1) {
                            isLowerThan1 = true;
                            break;
                        }
                    }
                    if (isLowerThan1) {
                        System.out.println(car1.getModel());
                    }
                }
            }

        } else if (command.equals("flamable")) {
            for (Car car1 : carList) {
                if (car1.getCargo().getTypeCargo().equals("flamable")) {
                    int currentPower = car1.getEngine().getPower();
                    if (currentPower > 250) {
                        System.out.println(car1.getModel());
                    }
                }
            }

        }
    }
}
