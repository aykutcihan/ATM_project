package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int pinNumber;
    private double checkingBalance; // used for daily transactions usually for paying bills, writing checks and debit card transactions
    private double savingBalance;  // money accumulated and available in a bank account

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00"); // we used in getCheckingWithdraw method

    Scanner input = new Scanner(System.in);

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    // withdrawal
    private double calculateCheckingBalanceAfterWithdraw(double amount) {

        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    // calculation of remaining balance after deposit transaction
    private double calculateCheckingBalanceAfterDeposit(double amount) {

        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    // withdrawal : remaining balance after money is withdrawn from saving account
    private double calculateSavingBalanceAfterWithdraw(double amount) {

        savingBalance = savingBalance - amount;
        return savingBalance;

    }

    // deposit : calculate the remaining balance after depositing money into the saving account
    private double calculateSavingBalanceAfterDeposit(double amount) {

        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    // Let's interact with the customer to withdraw money
    public void getCheckingWithdraw() {
        displayCurrentCheckingAmount(checkingBalance);
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Zero and negative numbers are invalid ");
            getCheckingWithdraw(); // recursive method // calling the method again
        } else if (amount <= checkingBalance) {

            calculateCheckingBalanceAfterWithdraw(amount);
            displayCurrentCheckingAmount(checkingBalance);

        }
    }

    // Deposit (checking): Let's interact with the customer to deposit money
    public void getCheckingDeposit() {
        displayCurrentCheckingAmount(checkingBalance);
        System.out.println("Enter the amount you want to deposit: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Zero or negative numbers are invalid! ");
            getCheckingDeposit();
        } else {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println();
            System.out.println();
            displayCurrentCheckingAmount(checkingBalance);
        }

    }

    public void getSavingWithdraw() {
        displayCurrentCheckingAmount(savingBalance);
        System.out.println("Enter the amount you want to withdraw");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Zero and negative numbers are invalid ");
            getSavingWithdraw();

        } else if (amount <= savingBalance) {
            calculateCheckingBalanceAfterWithdraw(amount);
            System.out.println();
            displayCurrentCheckingAmount(savingBalance);

        } else {
            System.out.println("Insufficient balance: ");
        }
    }

    // Withdrawal (savingBalance): Let's interact with the customer to deposit money

    public void getSavingDeposit() {
        displayCurrentCheckingAmount(savingBalance);
        System.out.println("Enter the amount you want to deposit");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Zero or negative numbers are invalid!");
            getSavingDeposit();
        } else {
            calculateSavingBalanceAfterDeposit(amount);
            displayCurrentCheckingAmount(savingBalance);

        }
    }

    // Let's create a method that shows the final balance
    public void displayCurrentCheckingAmount(double balance) {
        System.out.println("The balance in your account is: " + moneyFormat.format(balance));
    }
}



