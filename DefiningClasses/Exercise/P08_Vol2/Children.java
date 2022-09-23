package Advanced.DefiningClasses.Exercise.P08_Vol2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Children {
    public List<String> getChildList() {
        return childSet;
    }

    private List<String> childSet;


    public Children() {
        this.childSet = new ArrayList<>();
    }

    public void addChildToList(String child) {
        this.getChildList().add(child);
    }
}
