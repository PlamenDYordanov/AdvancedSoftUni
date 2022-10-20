package Advanced.Exam_December_2019_15.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (capacity > this.data.size()){
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        Present heaviestPresent = this.data.stream()
                .max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
        return heaviestPresent;
    }

    public Present getPresent(String name) {
        return this.data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("%s bag contains:",getColor()));
        for (Present present : this.data) {
            sb.append("\n");
            sb.append(present.toString());
        }
        return sb.toString();
    }
}
