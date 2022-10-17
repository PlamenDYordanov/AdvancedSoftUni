package Advanced.ExamPreparation_2022_05.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(currentPetName -> currentPetName.getName().equals(name));

    }

    public Pet getOldestPet() {
        Pet pet = null;
        int minAge = Integer.MIN_VALUE;
        for (Pet curPet : data) {
            if (curPet.getAge() > minAge) {
                minAge = curPet.getAge();
                pet = curPet;
            }
        }
        return pet;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet curPet : data) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:" + "\n");
        for (Pet curPet : data) {
            sb .append(String.format("%s %s",curPet.getName(), curPet.getOwner() + "\n"));
        }
        return sb.toString();
    }
}
