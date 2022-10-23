package Advanced.RegularExam.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (capacity > this.data.size()){
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
       return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream().filter(currentPet -> currentPet.getName().equals(name) && currentPet.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {
        return this.data.stream()
                 .max(Comparator.comparingDouble(Animal::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The Advanced.RegularExam.shelter has the following animals:");
        for (Animal curAnimal : data) {
            sb.append("\n");
            sb.append(curAnimal.getName()).append(sb.append(" ")).append(sb.append(curAnimal.getCaretaker()));
        }
        return sb.toString();
    }
}
