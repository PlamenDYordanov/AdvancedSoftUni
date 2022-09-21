package Advanced.DefiningClasses.Exercise.P07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parentList;
    private List<Children> childrenList;
    private List<Pokemon> pokemonList;

    public Person(String name) {
        this.pokemonList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
        this.parentList = new ArrayList<>();
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(String nameModel, Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParent(String nameModel, Parent parent) {
        this.parentList.add(parent);
    }

    public void addChildren(String nameModel, Children children) {
        this.childrenList.add(children);
    }

    @Override
    public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("Company:").append("\n");
            if (company != null){
                builder.append(company).append("\n");

            }
            builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }
        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemonList) {
            builder.append(pokemon).append("\n");
        }
        builder.append("Parents:").append("\n");
        for (Parent parent : parentList) {
            builder.append(parent).append("\n");
        }
        builder.append("Children:").append("\n");
        for (Children child : childrenList) {
            builder.append(child).append("\n");
        }
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        if (company == null) {
            return "";
        } else {
            return company.getDepartment();
        }

    }

    public double getCompanySalary() {
        if (company == null) {
            return 0;
        } else {
            return company.getSalary();
        }

    }
    public String getCarModel(){
        if (car == null){
            return "";
        }else {
            return car.getModel();
        }
    }
    public String getCarSpeed(){
        if (car == null){
            return "";
        }else {
            return car.getSpeed();
        }
    }

}
