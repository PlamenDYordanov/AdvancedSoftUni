package Advanced.Exam_February_2022_03.parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return this.species;
    }

    public boolean isAvailable() {
        return this.available;
    }
    public boolean setAvailable(boolean bool){
        return available = false;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s",getSpecies(),getName());
    }
}
