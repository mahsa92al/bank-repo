package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.TransactionType;

import java.util.Scanner;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Customer extends Account {
    Scanner scanner = new Scanner(System.in);
    private long nationalId;
    private String name;
    private MyDate openingDate;
    private double openingFund;
    private long bankAccount;
    private AccountType accountType;

    Account[] accounts = new Account[3];
    static int accountIndex = 0;

    public long getNationalId() {
        return nationalId;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(MyDate openingDate) {
        this.openingDate = openingDate;
    }

    public double getOpeningFund() {
        return openingFund;
    }

    public void setOpeningFund(double openingFund) {
        this.openingFund = openingFund;
    }

    @Override
    public long getBankAccount() {
        return bankAccount;
    }

    @Override
    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customer(long nationalId, String name, MyDate openingDate, double openingFund, AccountType accountType) {
        this.nationalId = nationalId;
        this.name = name;
        this.openingDate = openingDate;
        this.openingFund = openingFund;
        this.bankAccount = (int) (Math.random() * 999999 - 100000 + 1) + 100000;
        this.accountType = accountType;
    }

    public void addNewAccountBank(MyDate openingDate, double openingFund) {
        accounts[accountIndex] = new Account();

        accounts[accountIndex].setBankAccount((int) (Math.random() * 999999 - 100000 + 1) + 100000);
        accounts[accountIndex].setOpeningDate(openingDate);
        accounts[accountIndex].setOpeningFund(openingFund);
        accounts[accountIndex].setFund(accounts[accountIndex].getOpeningFund());
        accounts[accountIndex].setCurrentDate(openingDate);
        accounts[accountIndex].setTransactionType(TransactionType.DEPOSIT);
        accountIndex++;
    }

    public void printAccounts() {
        for (int i = 0; i < accountIndex; i++) {
            System.out.println("Bank account: " + accounts[i].getBankAccount() + ", Account type: " + accounts[i].getAccountType()
                    + ", Account opening date: " + (accounts[i].getOpeningDate()).toString() + ", Account opening fund: " + accounts[i].getOpeningFund()
                    + ", Fund: " + accounts[i].getFund());
        }
    }

    public void withDraw(long bankAccount, double money) {
        System.out.println("Day:");
        int day = scanner.nextInt();
        System.out.println("Month:");
        int month = scanner.nextInt();
        System.out.println("Year:");
        int year = scanner.nextInt();
        MyDate myDate = new MyDate(day, month, year);
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].getBankAccount() != bankAccount) {
                System.out.println("The bank account is not exist!");
            }
        }
        for (int j = 0; j < accountIndex; j++) {
            if (accounts[j].getBankAccount() == bankAccount) {
                if ((accounts[j].getAccountType()).equals(AccountType.CHECKING)) {
                    if (money > 2000000) {
                        System.out.println("Amount of the money must be under 2000000 T!");
                    } else {
                        accounts[j].setFund(accounts[j].getFund() - money - 700d);
                        accounts[j].setCurrentDate(myDate);
                        accounts[j].setTransactionType(TransactionType.WITHDRAW);
                        System.out.println("Withdraw done successfully.");
                    }
                } else {
                    accounts[j].setFund(accounts[j].getFund() - money);
                    System.out.println("Withdraw done successfully.");
                }
                break;
            }
        }
    }

    public void deposit(long bankAccount, double money) {
        System.out.println("Day:");
        int day = scanner.nextInt();
        System.out.println("Month:");
        int month = scanner.nextInt();
        System.out.println("Year:");
        int year = scanner.nextInt();
        MyDate myDate = new MyDate(day, month, year);
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].getBankAccount() != bankAccount) {
                System.out.println("The bank account is not exist!");
            }
        }
        for (int j = 0; j < accountIndex; j++) {
            if (accounts[j].getBankAccount() == bankAccount) {
                accounts[j].setFund(accounts[j].getFund() + money);
                accounts[accountIndex].setCurrentDate(myDate);
                accounts[accountIndex].setTransactionType(TransactionType.DEPOSIT);
                System.out.println("Deposit done successfully.");
            }
        }
    }

    public void calculateInterest(long bankAccount) {
        System.out.println("Enter current year:");
        int currentYear = scanner.nextInt();
        System.out.println("Enter previous month:");
        int previousMonth = scanner.nextInt();
        MyDate myDate = new MyDate(previousMonth);
        myDate.setDay(myDate.getMonthLastDate(previousMonth));
        myDate.setMonth(previousMonth);
        myDate.setYear(currentYear);
        for (int i = 0; i < accountIndex; i++) {
            double interest;
            if (accounts[i].getBankAccount() == bankAccount) {
                if (accounts[i].getAccountType().equals(AccountType.SAVING)) {
                    //accounts[i] = new Saving();    // I want to use the polymorphism.
                    //interest = accounts[i].calculateInterest();
                    interest = accounts[i].getFund() * 0.1 + accounts[i].getFund();
                    System.out.println(interest);
                    accounts[i].setCurrentDate(myDate);
                    accounts[i].setTransactionType(TransactionType.INTEREST);
                    break;
                } else if (accounts[i].getAccountType().equals(AccountType.LOAN)) {
                    //accounts[i] = new Loan();     // I want to use the polymorphism.
                    //interest = accounts[i].calculateInterest();
                    interest = (0.18 * 3000000)/36;
                    System.out.println(interest);
                    accounts[i].setCurrentDate(myDate);
                    accounts[i].setTransactionType(TransactionType.INTEREST);
                    break;
                }
            }
        }
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].getBankAccount() != bankAccount) {
                System.out.println("There is no bank account= " + bankAccount);
            }
        }
    }

    public void viewTransactions(long bankAccount){
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].getBankAccount() != bankAccount) {
                System.out.println("There is no bank account= " + bankAccount);
            }
        }
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].getBankAccount() == bankAccount){
                System.out.println(accounts[i].getTransactionType() + ", " + accounts[i].getFund() + ", "
                + (accounts[i].getCurrentDate()).toString());
                System.out.println(" ");
            }
        }
    }
}
