package Advanced.DefiningClasses.Exercise.P07_Google;

public class Children {
    private String name;
    private String birthDay;

    public Children(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return name + " " + birthDay;
    }
}
