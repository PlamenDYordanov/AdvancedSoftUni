package Advanced.ExamPreparation_2022_06.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        Employee employee = null;
        int age = Integer.MIN_VALUE;
        for (Employee currEmployee : employees) {
            if (currEmployee.getAge() > age) {
                age = currEmployee.getAge();
                employee = currEmployee;

            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        Employee employee = null;
        for (Employee curEmployee : employees) {
            if (curEmployee.getName().equals(name)) {
                employee = curEmployee;
            }
        }
        return employee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String getName() {
        return name;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:", getName()));
        sb.append("\n");
        for (Employee employee : this.employees) {
            sb.append(employee);
            sb.append("\n");
        }
        return sb.toString();
    }
}
