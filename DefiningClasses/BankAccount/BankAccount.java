package Advanced.DefiningClasses.BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int idCounter = 1;
    private int id;
    private  double balance;

    public BankAccount() {
        this.id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
    public void deposit (double amount){
        this.balance += amount;

    }
    public double getInterestRate(int year){
        return  BankAccount.interestRate * year * this.balance;
    }
}
