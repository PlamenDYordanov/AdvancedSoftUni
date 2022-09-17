package Advanced.DefiningClasses.Exercise.P04_RawData;

public class Cargo {
    private String typeCargo;
    private int weightCargo;

    public Cargo(String typeCargo, int weightCargo) {
        this.typeCargo = typeCargo;
        this.weightCargo = weightCargo;
    }

    public String getTypeCargo() {
        return typeCargo;
    }

    public void setTypeCargo(String typeCargo) {
        this.typeCargo = typeCargo;
    }

    public int getWeightCargo() {
        return weightCargo;
    }

    public void setWeightCargo(int weightCargo) {
        this.weightCargo = weightCargo;
    }
}
