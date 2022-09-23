package Advanced.DefiningClasses.Exercise.P09_CatLady;

public class StreetExtraordinary {
    private String name;
    private double decibel;

    public StreetExtraordinary(String name, double decibel) {
        this.name = name;
        this.decibel = decibel;
    }
    public String toString(){
        return  String.format("%s %s %.2f", "StreetExtraordinaire", name, decibel);
    }

    public String getName() {
        return name;
    }

    public double getDecibel() {
        return decibel;
    }
}
