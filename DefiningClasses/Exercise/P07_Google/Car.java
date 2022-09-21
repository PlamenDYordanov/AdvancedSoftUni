package Advanced.DefiningClasses.Exercise.P07_Google;

public class Car {
    private String model = "";
    private String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {

        return model + " " + speed;
    }
}
