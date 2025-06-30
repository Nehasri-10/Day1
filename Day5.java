import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5{
    private double balance;
    private List<String> transactionHistory;
    public Account(double initialBalance) {
        this.balance=initialBalance;
        this.transactionHistory=new ArrayList<>();
        recordTransaction("Account created with initial balance: $" + initialBalance);
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance+=amount;
            recordTransaction("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount>0 && amount<=balance) {
            balance-=amount;
            recordTransaction("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    public double getBalance() {
        return balance;
    }
    private void recordTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter initial balance: $");
        double initialBalance=sc.nextDouble();
        Account myAccount=new Account(initialBalance);
        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount=sc.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount=sc.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + myAccount.getBalance());
                    break;
                case 4:
                    myAccount.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice!=5);
    }
}
