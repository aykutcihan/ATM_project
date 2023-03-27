package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pinNumber;
    private double checkingBalance; // Used for daily transactions, such as paying bills, writing checks, and using ATM cards
    private double savingBalance;  // The accumulated and available money in a bank account

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00"); // Used in the getCheckingWithdraw method

    Scanner input = new Scanner(System.in);

    // Getter and Setter methods for accountNumber, pinNumber, checkingBalance, savingBalance, and input

    // Calculate the checking balance after a withdrawal
    private double calculateCheckingBalanceAfterWithdraw(double amount) {
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    // Calculate the checking balance after a deposit
    private double calculateCheckingBalanceAfterDeposit(double amount) {
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    // Calculate the saving balance after a withdrawal
    private double calculateSavingBalanceAfterWithdraw(double amount) {
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    // Calculate the saving balance after a deposit
    private double calculateSavingBalanceAfterDeposit(double amount) {
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    // Interact with the customer to withdraw from the checking account
    public void getCheckingWithdraw() {
        displayCurrentCheckingAmount(checkingBalance);
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Zero and negative values are invalid");
            getCheckingWithdraw(); // Recursive method to call the method again
        } else if (amount <= checkingBalance) {
            calculateCheckingBalanceAfterWithdraw(amount);
            displayCurrentCheckingAmount(checkingBalance);
        }
    }

    // Interact with the customer to deposit into the checking account
    public void getCheckingDeposit() {
        displayCurrentCheckingAmount(checkingBalance);
        System.out.println("Enter the amount you want to deposit: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Zero and negative values are invalid");
            getCheckingDeposit();
        } else {
            calculateCheckingBalanceAfterDeposit(amount);
            displayCurrentCheckingAmount(checkingBalance);
        }
    }

    // Interact with the customer to withdraw from the saving account
    public void getSavingWithdraw() {
        displayCurrentCheckingAmount(savingBalance);
        System.out.println("Enter the amount you want to withdraw");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Zero and negative values are invalid");
            getSavingWithdraw();
        } else if (amount <= savingBalance) {
            calculateSavingBalanceAfterWithdraw(amount);
            displayCurrentCheckingAmount(savingBalance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Interact with the customer to deposit into the saving account
    public void getSavingDeposit() {
        displayCurrentCheckingAmount(savingBalance);
        System.out.println("Enter the amount you want to deposit");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Zero and negative values are invalid");
            getSavingDeposit();
        } else {
            calculateSavingBalanceAfterDeposit(amount);
            displayCurrentCheckingAmount(savingBalance);
        }
    }

    // Create a method to display the current balance
    public void displayCurrentCheckingAmount(double balance) {
        System.out.println("Available balance in your account: " + moneyFormat.format(balance));
    }
}


