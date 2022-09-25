package Generics.Exercise.P10_Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tuple tuple = new Tuple();


        String firstInput = scanner.nextLine();
        String[] firstTokens = firstInput.split("\\s+");
        String firstName = firstTokens[0];
        String secondName = firstTokens[1];
        String address = firstTokens[2];
        tuple.add(firstName, tuple.getItemOne());
        tuple.add(secondName, tuple.getItemOne());
        tuple.add(address, tuple.getItemTwo());
        tuple.print();
        tuple.clear();

        String SecondInput = scanner.nextLine();
        String[] secondTokens = SecondInput.split("\\s+");
        String name = secondTokens[0];
        int littersOfBeer = Integer.parseInt(secondTokens[1]);
        tuple.add(name, tuple.getItemOne());
        tuple.add(littersOfBeer, tuple.getItemTwo());
        tuple.print();
        tuple.clear();

        String thirdInput = scanner.nextLine();
        String[] thirdTokens = thirdInput.split("\\s+");
        int integer = Integer.parseInt(thirdTokens[0]);
        double numDouble = Double.parseDouble(thirdTokens[1]);
        tuple.add(integer,tuple.getItemOne());
        tuple.add(numDouble, tuple.getItemTwo());
        tuple.print();

    }

}
