package Advanced.Exam_December_2021_04.P03_Aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        boolean isExist = false;
        for (Fish curFish : fishInPool) {
            if (curFish.getName().equals(fish.getName())) {
                isExist = true;
                break;
            }
        }
        if (getCapacity() > fishInPool.size() && !isExist) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        Fish fish = null;
        for (Fish curFish : fishInPool) {
            if (curFish.getName().equals(name)) {
                fish = curFish;
            }
        }
        return fish;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", name, size));
        sb.append("\n");
        for (Fish fish : fishInPool) {
            sb.append(fish);
            sb.append("\n");
        }
        return sb.toString();
    }
}
