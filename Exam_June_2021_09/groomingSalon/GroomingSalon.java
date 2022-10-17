package Advanced.Exam_June_2021_09.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet curPet : this.data) {
            if (curPet.getName().equals(name) && curPet.getOwner().equals(owner)) {
                pet = curPet;
            }
        }
        return pet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The grooming salon has the following clients:");
        for (Pet curPet : this.data) {
            sb.append("\n");
            sb.append(curPet.getName()).append(" ").append(curPet.getOwner());
        }
        return sb.toString();
    }
}
