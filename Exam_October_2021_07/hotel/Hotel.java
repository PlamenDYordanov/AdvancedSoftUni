package Advanced.Exam_October_2021_07.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > this.roster.size()) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(list -> list.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        Person person = null;
        for (Person curPerson : this.roster) {
            if (curPerson.getName().equals(name) && curPerson.getHometown().equals(hometown)) {
                person = curPerson;
            }
        }
        return person;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getName() {
        return name;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the Advanced.Exam_October_2021_07.hotel %s are:", getName()));
        sb.append("\n");
        for (Person curPerson : this.roster) {
            sb.append(curPerson);
            sb.append("\n");
        }
        return sb.toString();
    }
}
