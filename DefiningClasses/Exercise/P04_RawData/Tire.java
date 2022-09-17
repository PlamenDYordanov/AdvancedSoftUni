package Advanced.DefiningClasses.Exercise.P04_RawData;

import java.util.List;

public class Tire {
    private List<String> tireAge;
    private List<Double> tirePressure;

    public Tire(List<String> tireAge, List<Double> tirePressure) {
        this.tireAge = tireAge;
        this.tirePressure = tirePressure;
    }

    public List<String> getTireAge() {
        return tireAge;
    }

    public void setTireAge(List<String> tireAge) {
        this.tireAge = tireAge;
    }

    public List<Double> getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(List<Double> tirePressure) {
        this.tirePressure = tirePressure;
    }
}
