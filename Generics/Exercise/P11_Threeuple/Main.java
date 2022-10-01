package Generics.Exercise.P11_Threeuple;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tuple tuple = new tuple();


        String firstInput = scanner.nextLine();
        String[] firstTokens = firstInput.split("\\s+");
        String firstName = firstTokens[0];
        String secondName = firstTokens[1];
        String address = firstTokens[2];
        String town = firstTokens[3];
        tuple.add(firstName, tuple.getItemOne());
        tuple.add(secondName, tuple.getItemOne());
        tuple.add(address, tuple.getItemTwo());
        tuple.add(town, tuple.getItemThree());
        tuple.print();
        tuple.clear();

        String SecondInput = scanner.nextLine();
        String[] secondTokens = SecondInput.split("\\s+");
        String name = secondTokens[0];
        int littersOfBeer = Integer.parseInt(secondTokens[1]);
        String drunkOrNot = secondTokens[2];
        tuple.add(name, tuple.getItemOne());
        tuple.add(littersOfBeer, tuple.getItemTwo());
        if (tuple.drunkOrNot(drunkOrNot)) {
            tuple.add("true", tuple.getItemThree());
        } else {
            tuple.add("false", tuple.getItemThree());

        }
        tuple.print();
        tuple.clear();

        String thirdInput = scanner.nextLine();
        String[] thirdTokens = thirdInput.split("\\s+");
        String customerName = thirdTokens[0];
        double accountBalance = Double.parseDouble(thirdTokens[1]);
        String bankName = thirdTokens[2];
        tuple.add(customerName, tuple.getItemOne());
        tuple.add(accountBalance, tuple.getItemTwo());
        tuple.add(bankName, tuple.getItemThree());
        tuple.print();

    }

}
