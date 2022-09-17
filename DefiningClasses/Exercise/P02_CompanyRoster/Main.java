package Advanced.DefiningClasses.Exercise.P02_CompanyRoster;



import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Department> mapOfDep = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        Employee employee;
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String name = inputLine[0];
            double salary = Double.parseDouble(inputLine[1]);
            String position = inputLine[2];
            String department = inputLine[3];
            if (inputLine.length == 4) {
                employee = new Employee(name, salary, position, department, "n/a", -1);
            } else if (inputLine.length == 5) {
                if (inputLine[4].contains("@")) {
                    String email = inputLine[4];
                    employee = new Employee(name, salary, position, department, email, -1);
                } else {
                    int age = Integer.parseInt(inputLine[4]);
                    employee = new Employee(name, salary, position, department, "n/a", age);
                }


            } else {
                String email = inputLine[4];
                int age = Integer.parseInt(inputLine[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
         mapOfDep.putIfAbsent(department,new Department(department));
            mapOfDep.get(department).getEmployeeList().add(employee);
        }
        Department highestSalary = mapOfDep.entrySet()
                .stream()
                .max(Comparator.comparingDouble(e -> e.getValue().averageSalary())).get()
                .getValue();


        System.out.printf("Highest Average Salary: %s%n", highestSalary.getName());

       highestSalary.getEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
               .forEach(p -> System.out.printf("%s %.2f %s %d%n", p.getName(), p.getSalary(), p.getEmail(), p.getAge()));


    }
}
