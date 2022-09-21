package Advanced.DefiningClasses.Exercise.P07_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> personMap = new HashMap<>();
        String inputLine = scanner.nextLine();
        //only one car and company!
        Car car;
        Children children;
        Company company;
        Parent parent;
        Pokemon pokemon;
        Person person = null;
        while (!inputLine.equals("End")) {
            String personName = inputLine.split("\\s+")[0];
            String typeOfObject = inputLine.split("\\s+")[1];
            person = new Person(personName);
            personMap.putIfAbsent(personName, person);

            switch (typeOfObject) {
                case "company":
                    String companyName = inputLine.split("\\s+")[2];
                    String department = inputLine.split("\\s+")[3];
                    double salary = Double.parseDouble(inputLine.split("\\s+")[4]);
                    company = new Company(companyName, department, salary);
                    personMap.get(personName).setCompany(company);
                    break;
                case "pokemon": {
                    String name = inputLine.split("\\s+")[2];
                    String type = inputLine.split("\\s+")[3];
                    pokemon = new Pokemon(name, type);
                    personMap.get(personName).addPokemon(name, pokemon);
                    break;
                }
                case "parents": {
                    String name = inputLine.split("\\s+")[2];
                    String Birthday = inputLine.split("\\s+")[3];
                    parent = new Parent(name, Birthday);
                    personMap.get(personName).addParent(name,parent);
                }
                break;
                case "children": {
                    String name = inputLine.split("\\s+")[2];
                    String Birthday = inputLine.split("\\s+")[3];
                    children = new Children(name, Birthday);
                    personMap.get(personName).addChildren(name, children);
                }
                break;

                case "car": {
                    String model = inputLine.split("\\s+")[2];
                    String speed = inputLine.split("\\s+")[3];
                    car = new Car(model, speed);
                    person.setCar(car);
                    personMap.get(personName).setCar(car);
                }
                break;
            }


            inputLine = scanner.nextLine();
        }
        inputLine = scanner.nextLine();
        String searchPerson = inputLine;
        Person personalData =  personMap.get(searchPerson);
        System.out.println(personalData);

    }
}
