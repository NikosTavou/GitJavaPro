package myProjects.BankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private final List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountHolderName, double initialBalance) {
        int accountNumber =  (accounts.size()+1 );
        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully. Account Number: " + accountNumber);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber + 1)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    public double checkBalance(String accountNumber) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Bank");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(name, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(accNum, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accNum = scanner.nextLine();
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(accNum, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accNum = scanner.nextLine();
                    double balance = bank.checkBalance(accNum);
                    System.out.println("Current Balance: $" + balance);
                    break;
                case 5:
                    System.out.println("Thank you for using the bank system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}
