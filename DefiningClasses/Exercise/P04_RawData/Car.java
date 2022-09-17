package Advanced.DefiningClasses.Exercise.P04_RawData;

public class Car {
    private String model;
    private Cargo cargo;
    private Engine engine;
    private Tire tire;



    public Car(String model, Cargo cargo, Engine engine, Tire tire) {
        this.model = model;
        this.cargo = cargo;
        this.engine = engine;
        this.tire = tire;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
