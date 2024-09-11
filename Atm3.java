import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM() {
        bankAccount = new BankAccount(0);
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayOptions();
            System.out.print("Enter the option number: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                System.out.print("Enter the amount to deposit: ");
                double amount = scanner.nextDouble();
                deposit(amount);
            } else if (choice == 3) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = scanner.nextDouble();
                withdraw(amount);
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
        scanner.close();
    }

    public void checkBalance() {
        System.out.println("Your account balance is: $" + bankAccount.checkBalance());
    }

    public void deposit(double amount) {
        if (bankAccount.deposit(amount)) {
            System.out.println("Deposited $" + amount + " successfully. Your new balance is: $" + bankAccount.checkBalance());
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrew $" + amount + " successfully. Your new balance is: $" + bankAccount.checkBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance. Please try again.");
        }
    }
}

// Example usage:
public class Atm3 {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}