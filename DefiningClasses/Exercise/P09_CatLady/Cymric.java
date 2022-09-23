package Advanced.DefiningClasses.Exercise.P09_CatLady;

public class Cymric {
    private String name;
    private  double furLength;

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
    }
    @Override
    public String toString(){
        return String.format("%s %s %.2f","Cymric", name, furLength);
    }

    public String getName() {
        return name;
    }

    public double getFurLength() {
        return furLength;
    }
}
