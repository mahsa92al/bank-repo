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
        String nationalId;
        do{
            System.out.println("Enter customer national ID:");
            nationalId = scanner.next();
        }while (ValidationUtil.isNumeric(nationalId));
        String bankAccount;
        do{
            System.out.println("Enter Bank account:");
            bankAccount = scanner.next();
        }while (ValidationUtil.isNumeric(bankAccount));

        bank.viewTransactions(Long.parseLong(nationalId), Integer.parseInt(bankAccount));
    }

    private static void calcInterestOfAccount() {
        String nationalId;
        do{
            System.out.println("Enter customer national ID:");
            nationalId = scanner.next();
        }while (ValidationUtil.isNumeric(nationalId));
        String bankAccount;
        do{
            System.out.println("Enter Bank account:");
            bankAccount = scanner.next();
        }while (ValidationUtil.isNumeric(bankAccount));
        MyDate date = getDateFromUser();
        bank.calculateInterest(Long.parseLong(nationalId), Integer.parseInt(bankAccount), date);
    }

    private static void depositToAccount() {
        long nationalId = getNationalIDForWithdrawAndDeposit();
        int bankAccount = getAccountNumberForWithdrawAndDeposit();
        double amountOfMoney = getAmountOfMoneyForWithdrawAndDeposit();
        MyDate currentDate = getDateFromUser();
        bank.deposit(nationalId, bankAccount, amountOfMoney, currentDate);
    }

    private static void withdrawFromAccount() {
        long nationalId = getNationalIDForWithdrawAndDeposit();
        int bankAccount = getAccountNumberForWithdrawAndDeposit();
        double amountOfMoney = getAmountOfMoneyForWithdrawAndDeposit();
        MyDate currentDate = getDateFromUser();
        bank.withDraw(nationalId, bankAccount, amountOfMoney, currentDate);
    }

    private static long getNationalIDForWithdrawAndDeposit(){
        String nationalId;
        do{
            System.out.println("Enter customer national ID:");
            nationalId = scanner.next();
        }while (ValidationUtil.isNumeric(nationalId));
        return Long.parseLong(nationalId);
    }

    private static int getAccountNumberForWithdrawAndDeposit(){
        String bankAccount;
        do{
            System.out.println("Enter Bank account:");
            bankAccount = scanner.next();
        }while (ValidationUtil.isNumeric(bankAccount));
        return Integer.parseInt(bankAccount);
    }

    private static double getAmountOfMoneyForWithdrawAndDeposit(){
        String amountOfMoney;
        do{
            System.out.println("Enter amount of money:");
            amountOfMoney = scanner.next();
        }while (ValidationUtil.isNumeric(amountOfMoney));
        return Double.parseDouble(amountOfMoney);
    }

    private static MyDate getDateFromUser() {
        String day;
        do{
            System.out.println("Day:");
            day = scanner.next();
        }while (ValidationUtil.isNumeric(day));
        String month;
        do{
            System.out.println("Month:");
            month = scanner.next();
        }while (ValidationUtil.isNumeric(month));
        String year;
        do{
            System.out.println("Year:");
            year = scanner.next();
        }while (ValidationUtil.isNumeric(year));

        return new MyDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
    }

    private static void showAccountsByNationalId() {
        String nationalId;
        do{
            System.out.println("Customer national ID:");
            nationalId = scanner.next();
        }while (ValidationUtil.isNumeric(nationalId));
        bank.printCustomerAccount(Long.parseLong(nationalId));
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
        } while (!ValidationUtil.isNumeric(openingFund));
        String nationalId;
        do{
            System.out.println("Customer national ID:");
            nationalId = scanner.next();
        }while (!ValidationUtil.isNumeric(nationalId));
        String day;
        do{
            System.out.println("Day:");
            day = scanner.next();
        }while (!ValidationUtil.isNumeric(day));
        String month;
        do{
            System.out.println("Month:");
            month = scanner.next();
        }while (!ValidationUtil.isNumeric(month));
        String year;
        do{
            System.out.println("Year:");
            year = scanner.next();
        }while (!ValidationUtil.isNumeric(year));

        AccountType accountType = getUserAccountType();
        MyDate openingDate = new MyDate(Integer.parseInt(day),Integer.parseInt(month), Integer.parseInt(year));
        bank.addNewAccount(name, Long.parseLong(nationalId), Double.parseDouble(openingFund), openingDate, accountType);
    }

    private static AccountType getUserAccountType() {
        AccountType.showAccountTypes();
        System.out.println("Account type:");
        String choice;
        do{
            choice = scanner.next();
        }while (!ValidationUtil.isNumeric(choice));
        int accountChoice = Integer.parseInt(choice);
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
