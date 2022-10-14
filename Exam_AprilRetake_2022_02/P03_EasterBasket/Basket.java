package Advanced.Exam_AprilRetake_2022_02.P03_EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (capacity > data.size()) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String pink) {
        boolean isExist = false;
        for (Egg egg : data) {
            if (egg.getColor().equals(pink)) {
                this.data.remove(egg);
                isExist = true;
            }
        }
        return isExist;
    }

    public Egg getStrongestEgg() {
        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n",material));
        for (Egg egg : data) {
            sb.append(egg.toString());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
