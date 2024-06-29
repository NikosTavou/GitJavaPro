package myProjects.BankApp.Exceptions;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(){
        System.out.println("Insufficient balance, try again!");
    }
}
