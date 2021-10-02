package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.ManagerMenu;

import java.util.Scanner;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = new Bank();

    public static void main(String[] args) {

        String choice;
        int choiceNumber;
        do {
            ManagerMenu.showManagementMenu();

            do {
                choice = scanner.next();
            } while (!ValidationUtil.isNumeric(choice));

            choiceNumber = Integer.parseInt(choice);

            switch (choiceNumber) {
                case 1:
                    addAccountBank();
                    break;
                case 2:
                    showAccountsByNationalId();
                    break;
                case 3:
                    withdrawFromAccount();
                    break;
                case 4:
                    depositToAccount();
                    break;
                case 5:
                    calcInterestOfAccount();
                    break;
                case 6:
                    showAccountTransaction();
                    break;
                case 7:
                    System.out.println("***goodbye***");
                    break;
                default:
                    System.out.println("Invalid value");
            }
        } while (choiceNumber != 7);

    }

    private static void showAccountTransaction() {
        System.out.println("Enter customer national ID:");
        long nationalId = scanner.nextLong(); //// add regex here
        System.out.println("Enter Bank account:");
        long bankAccount = scanner.nextLong(); //// add regex here
        bank.viewTransactions(nationalId, bankAccount);
    }

    private static void calcInterestOfAccount() {
        System.out.println("Enter customer national ID:");
        long nationalId = scanner.nextLong(); //// add regex here
        System.out.println("Enter Bank account:");
        long bankAccount = scanner.nextLong(); //// add regex here
        MyDate date = getDateFromUser();
        bank.calculateInterest(nationalId, bankAccount, date);
    }

    private static void depositToAccount() {
        System.out.println("Enter customer national ID:");
        long nationalId = scanner.nextLong(); //// add regex here
        System.out.println("Enter Bank account:");
        long bankAccount = scanner.nextLong(); //// add regex here
        System.out.println("Enter amount of money:");
        double amountOfMoney = scanner.nextDouble(); //// add regex here
        MyDate currentDate = getDateFromUser();
        bank.deposit(nationalId, bankAccount, amountOfMoney, currentDate);
    }

    private static void withdrawFromAccount() {
        System.out.println("Enter customer national ID:");
        long nationalId = scanner.nextLong(); //// add regex here
        System.out.println("Enter Bank account:");
        long bankAccount = scanner.nextLong(); //// add regex here
        System.out.println("Enter amount of money:");
        double amountOfMoney = scanner.nextDouble(); //// add regex here
        MyDate currentDate = getDateFromUser();
        bank.withDraw(nationalId, bankAccount, amountOfMoney, currentDate);
    }

    private static MyDate getDateFromUser() {
        System.out.println("Day:");
        int day = scanner.nextInt();
        System.out.println("Month:");
        int month = scanner.nextInt();
        System.out.println("Year:");
        int year = scanner.nextInt();
        return new MyDate(day, month, year);
    }

    private static void showAccountsByNationalId() {
        System.out.println("Customer national ID:");
        long nationalId = scanner.nextLong();/////add regex here
        bank.printCustomerAccount(nationalId);
    }

    private static void addAccountBank() {
        String name;
        do {
            System.out.println("Customer Name:");
            System.out.println("Name:");
            name = scanner.next();
        } while (!ValidationUtil.isAlphabetic(name));

        String openingFund;
        do {
            System.out.println("Opening fund:");
            openingFund = scanner.next();
        } while (!ValidationUtil.isValidPhoneNumber(openingFund));

        System.out.println("Customer national ID:");
        long nationalId = scanner.nextLong();/////add regex here
        System.out.println("Day:");
        int day = scanner.nextInt();
        System.out.println("Month:");
        int month = scanner.nextInt();
        System.out.println("Year:");
        int year = scanner.nextInt();
        AccountType accountType = getUserAccountType();
        MyDate openingDate = new MyDate(day, month, year);
        bank.addNewAccount(name, nationalId, Double.parseDouble(openingFund), openingDate, accountType);
    }

    private static AccountType getUserAccountType() {
        AccountType.showAccountTypes();
        System.out.println("Account type:");
        int accountChoice = scanner.nextInt();
        AccountType accountType = null;
        if (accountChoice == 1) {
            accountType = AccountType.CHECKING;
        } else if (accountChoice == 2) {
            accountType = AccountType.SAVING;
        } else if (accountChoice == 3) {
            accountType = AccountType.LOAN;
        }
        return accountType;
    }

}
