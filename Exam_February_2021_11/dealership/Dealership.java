package Advanced.Exam_February_2021_11.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > this.data.size()){
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
       return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car car = null;
        int age = Integer.MIN_VALUE;
        for (Car car1 : data) {
            if (age < car1.getYear()){
                age = car1.getYear();
                car = car1;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
      return   this.data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The cars are in a car Advanced.Exam_February_2021_11.dealership %s:", name));
        for (Car car : this.data) {
            sb.append("\n");
            sb.append(car);
        }
        return sb.toString();
    }
}
