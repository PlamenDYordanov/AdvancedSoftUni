package Advanced.DefiningClasses.Exercise.P08_Vol2;

import java.util.*;

public class Parent {
    private List<String> parentSet;


    public Parent() {
        this.parentSet = new ArrayList<>();
    }

    public void addToParentList(String parent) {
        this.parentSet.add(parent);
    }


    public List<String> getParentSet() {
        return parentSet;
    }
}
