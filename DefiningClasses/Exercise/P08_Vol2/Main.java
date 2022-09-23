package Advanced.DefiningClasses.Exercise.P08_Vol2;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        Person person = new Person();
        Children children = new Children();
        Parent parent = new Parent();
        if (firstLine.contains("/")) {
            person.setBirthday(firstLine);
        } else {
            person.setName(firstLine);
        }

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {
            if (inputLine.contains("-")) {
                String[] splitInput = inputLine.split(" - ");

                children.addChildToList(splitInput[1]);
                parent.addToSet(splitInput[0]);


            } else {
                String[] split = inputLine.split("\\s+");
                String name = split[0] + " " + split[1];
                String birthday = split[2];
                person.addPersonToMap(name,birthday);

            }


            inputLine = scanner.nextLine();
        }
        System.out.println();

        person.getNameOrBirthday();
        person.getParents(children.getChildList(),parent.getParentSet());
        person.getChildrenSet(children.getChildList(),parent.getParentSet());
        System.out.printf("%s %s%n",person.getName(),person.getBirthday());
        System.out.println("Parents:");
        for (String curParent : person.getParentList()) {
            for (Map.Entry<String, String> entry : person.getMapOfPerson().entrySet()) {
                if (curParent.equals(entry.getKey())){
                    System.out.printf("%s %s%n",entry.getKey(), entry.getValue());
                }else if (curParent.equals(entry.getValue())){
                    System.out.printf("%s %s%n",entry.getKey(), entry.getValue());
                }
            }

        }
        System.out.println("Children:");
        for (String curChild : person.getChildrenList()) {
            for (Map.Entry<String, String> entry : person.getMapOfPerson().entrySet()) {
                if (curChild.equals(entry.getKey())){
                    System.out.printf("%s %s%n",entry.getKey(), entry.getValue());
                }else if (curChild.equals(entry.getValue())){
                    System.out.printf("%s %s%n",entry.getKey(), entry.getValue());
                }
            }

        }
    }
}
