package Advanced.DefiningClasses.Exercise.P08_Vol2;

import java.util.*;

public class Person {
    private String name;
    private String birthday;
    private Map<String, String> mapOfPerson;
    private List<String> parentList;
    private List<String> childrenList;


    public Person() {
        this.mapOfPerson = new HashMap<>();
        this.parentList = new ArrayList<>();
        this.childrenList = new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void addPersonToMap(String name, String birthday) {
        mapOfPerson.putIfAbsent(name, birthday);
    }

    public void getNameOrBirthday() {
        if (this.name != null) {
            for (Map.Entry<String, String> entry : this.mapOfPerson.entrySet()) {
                if (entry.getKey().equals(this.name)) {
                    setBirthday(entry.getValue());
                    break;
                }
            }
        } else {
            for (Map.Entry<String, String> entry : this.mapOfPerson.entrySet()) {
                if (entry.getValue().equals(this.birthday)) {
                    setName(entry.getKey());
                    break;
                }
            }
        }

    }

    public void getParents(List<String> childrenList, List<String> parentList){
        int index = 0;
        for (String currentChild : childrenList) {
            if (currentChild.equals(this.name)||currentChild.equals(this.birthday)){
             this.parentList.add(parentList.get(index));
            }
            index ++;
        }

       /* for (String currentParentParameter : parent) {

            if (currentParentParameter.equals(getName())) {
                continue;
            }
            if (currentParentParameter.equals(getBirthday())) {
                continue;
            }
            for (Map.Entry<String, String> entry : this.mapOfPerson.entrySet()) {
                String currentName = entry.getKey();
                String currentBirth = entry.getValue();
                if (currentParentParameter.equals(currentName)) {
                    this.parentList.add(currentParentParameter);
                } else if (currentParentParameter.equals(currentBirth)) {
                    this.parentList.add(currentParentParameter);
                }

            }*/
        }




    public void getChildrenSet(List<String> childList, List<String> parentList) {

        int index = 0;
        for (String currentParent : parentList) {
            if (currentParent.equals(this.name)||currentParent.equals(this.birthday)){
                this.childrenList.add(childList.get(index));
            }
            index ++;
        }
       /* for (String currentChildParameter : childSet) {

            if (currentChildParameter.equals(getName())) {
                continue;
            }
            if (currentChildParameter.equals(getBirthday())) {
                continue;
            }
            for (Map.Entry<String, String> entry : this.mapOfPerson.entrySet()) {
                String currentName = entry.getKey();
                String currentBirth = entry.getValue();
                if (currentChildParameter.equals(currentName)) {
                    this.childrenList.add(currentChildParameter);
                } else if (currentChildParameter.equals(currentBirth)) {
                    this.childrenList.add(currentChildParameter);
                }

            }*/
        }


    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getParentList() {
        return parentList;
    }

    public List<String> getChildrenList() {
        return childrenList;
    }

    public Map<String, String> getMapOfPerson() {
        return mapOfPerson;
    }
}
