package myProjects.BankApp;

import myProjects.BankApp.Exceptions.InsufficientBalanceException;

import java.time.LocalDateTime;

public class User {
    String firstname;
    String lastname;
    int accountId;
    double balance;

    public User(String firstname, String lastname, int accountId, double balance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }

    public void deposit(double amount) {
        if (amount > 0)  {
            balance += amount;
        }
        System.out.println("Your account balance is: " + getBalance());
    }

    public void withdraw (double amount) throws InsufficientBalanceException {
        try {
            if (amount > balance) {
                throw new InsufficientBalanceException();
            }
            balance -= amount;
        } catch(InsufficientBalanceException e){
               System.out.println("Error in withdraw service: Insufficient account balance, " + LocalDateTime.now());
          throw e;
        }
        System.out.println("Your account balance is: " + getBalance());
    }
}
