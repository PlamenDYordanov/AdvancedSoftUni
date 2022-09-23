package Advanced.DefiningClasses.Exercise.P09_CatLady;

public class Siamese {
    private String name;
    private double earSize;

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }
    @Override

    public String toString(){
        return  String.format("%s %s %.2f", "Siamese", name, earSize);
    }

    public String getName() {
        return name;
    }

    public double getEarSize() {
        return earSize;
    }
}
