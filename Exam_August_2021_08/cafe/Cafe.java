package Advanced.Exam_August_2021_08.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (capacity > this.employees.size()){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return this.employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        Employee employee = null;
        int age = 0;
        for (Employee curEmployee : employees) {
            if (curEmployee.getAge() > age){
                employee = curEmployee;
                age = curEmployee.getAge();
            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        Employee employee = null;
        for (Employee curEmployee : employees) {
            if (curEmployee.getName().equals(name)){
                employee = curEmployee;
            }
        }
        return employee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:", this.name));
        for (Employee employee : this.employees) {
            sb.append("\n");
            sb.append(employee);
        }
        return sb.toString();
    }
}
