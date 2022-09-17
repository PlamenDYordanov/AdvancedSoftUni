package Advanced.DefiningClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        while (!input.equals("End")) {
            String output = null;
            String[] commands = input.split("\\s+");
            switch (commands[0]) {

                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
                case "Deposit": {
                    int id = Integer.parseInt(commands[1]);
                    int amount = Integer.parseInt(commands[2]);
                    if (bankAccountMap.containsKey(id)) {
                        bankAccount = bankAccountMap.get(id);  //!!!!!!!
                        bankAccount.deposit(amount);
                        output = "Deposited " + amount + " to " + "ID" + id;
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                }
                case "SetInterest":
                    double interestRate = Double.parseDouble(commands[1]);
                    BankAccount.setInterestRate(interestRate);//!!!!!
                    break;
                case "GetInterest":
                    int id = Integer.parseInt(commands[1]);
                    int year = Integer.parseInt(commands[2]);
                    if (bankAccountMap.containsKey(id)) {

                        output = String.format("%.2f", bankAccountMap.get(id).getInterestRate(year));
                    } else {
                        output = "Account does not exist";
                    }
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }

            input = scanner.nextLine();
        }
    }
}
