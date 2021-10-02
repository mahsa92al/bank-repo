package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.TransactionType;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Customer {

    private long nationalId;
    private String name;
    private Account[] accounts = new Account[3];
    private int accountIndex = 0;

    public Customer(long nationalId, String name) {
        this.nationalId = nationalId;
        this.name = name;
    }

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

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public int getAccountIndex() {
        return accountIndex;
    }

    public void setAccountIndex(int accountIndex) {
        this.accountIndex = accountIndex;
    }

    public Account addNewAccount(double openingFund, MyDate openingDate, AccountType accountType) {
        Account account = new Account(openingDate, openingFund, accountType);
        accounts[accountIndex] = account;
        accountIndex++;
        return account;
    }

    public void printAccounts() {
        for (int i = 0; i < accountIndex; i++) {
            System.out.println(accounts[i].toString());
        }
    }

    public void withDraw(long bankAccount, double money, MyDate currentDate) {
        Account account = findAccountByNumber(bankAccount);
        if (account != null)
            account.withdraw(money, currentDate);
    }

    public void deposit(long bankAccount, double money, MyDate currentDate) {
        Account account = findAccountByNumber(bankAccount);
        if (account != null)
            account.deposit(money, currentDate);
    }

    public Account findAccountByNumber(long accountNumber) {
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    public void calculateInterest(long bankAccount, MyDate date) {

        for(int i = 0; i < accountIndex; i++){
            if(accounts[i].getAccountNumber() == bankAccount){
                if(accounts[i] instanceof Saving){
                    Saving saving = (Saving) accounts[i];
                    saving.calculateInterest(date);
                }else if(accounts[i] instanceof Loan){
                    Loan loan = (Loan) accounts[i];
                    loan.calculateInterest(date);
                }
            }
        }

    }

    public void viewTransactions(long bankAccount) {
        Account account = findAccountByNumber(bankAccount);
        if (account != null)
            account.showTransactions();
    }
}
