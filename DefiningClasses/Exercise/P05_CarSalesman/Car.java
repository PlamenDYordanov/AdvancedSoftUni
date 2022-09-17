package Advanced.DefiningClasses.Exercise.P05_CarSalesman;

public class Car {
    private String model;
    private String engineModel;
    private String weight;
    private String color;
    private static Engine engine;


    public Car(String model, String engineModel, String weight, String color) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = color;


    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engineModel;
    }

    public void setEngine(String engine) {
        this.engineModel = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }


}
