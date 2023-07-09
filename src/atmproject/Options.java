package atmproject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account {

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    boolean flag = true;

    HashMap<Integer, Integer> data = new HashMap<>();

    public void login() {

        System.out.println("Welcome to XBank ATM");

        do {
            data.put(12345, 1234);
            data.put(23456, 2345);
            data.put(34567, 3456);
            data.put(45678, 4567);
            try {
                System.out.println("Please enter your account number");
                setAccountNumber(input.nextInt());
                System.out.println("Please enter your pin number");
                setPinNumber(input.nextInt());
            } catch (Exception e) {
                System.out.println("Invalid input, please only enter numbers or you can exit by pressing Q");

                input.nextLine();
                String exit = input.next();

                if (exit.equalsIgnoreCase("Q")) {
                    flag = false;
                }
            }

            int count = 0;
            for (Map.Entry<Integer, Integer> w : data.entrySet()) {
                if (w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())) {
                    getAccountTypes();
                } else {
                    count++;
                }
            }

            if (count == data.size()) {
                System.out.println("Wrong account number or pin number");
            }
        } while (flag);

        System.out.println("Enter the account number. ");
    }

    public void checkingOperation() {
        do {
            displayMessage();

            int option = input.nextInt();

            if (option == 4) {
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("Remaining balance in your checking account: " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingBalance();
                    break;
                case 3:
                    getCheckingDeposit();
                    break;
                default:
                    System.out.println("Wrong option, please use 1,2,3 or 4");

            }

        } while (true);
        getAccountTypes();
    }

    public void savingOperations() {
        do {

            displayMessage();

            int option = input.nextInt();

            if (option == 4) {
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("Remaining balance in your savings account: " + moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    getSavingWithdraw();
                    break;
                case 3:
                    getSavingDeposit();
                    break;
                default:
                    System.out.println("Wrong option, please use 1, 2, 3 or 4");
            }

        } while (true);
        getAccountTypes();

    }

    public void getAccountTypes() {

        System.out.println("Select the account you want to operate");
        System.out.println("1: Checking account");
        System.out.println("2: Saving account");
        System.out.println("3: Quit");

        int option = input.nextInt();

        switch (option) {
            case 1:
                System.out.println("You are in your Checking account");
                checkingOperation();
                break;
            case 2:
                System.out.println("You are in your Saving account");
                savingOperations();
                break;
            case 3:
                System.out.println("Thank you for using our ATM");
                flag = false;
                break;
            default:
                System.out.println("Wrong option! please use 1, 2 or 3");
        }
    }

    public void displayMessage() {
        System.out.println("Select an option");
        System.out.println("1: View Balance ");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
    }
}
