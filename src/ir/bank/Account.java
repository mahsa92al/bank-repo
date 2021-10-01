package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.TransactionType;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Account {

    private MyDate openingDate;
    private MyDate currentDate;
    private double openingFund;
    private long bankAccount;
    private AccountType accountType;
    private double fund;
    private TransactionType transactionType;

    public MyDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(MyDate openingDate) {
        this.openingDate = openingDate;
    }

    public MyDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(MyDate currentDate) {
        this.currentDate = currentDate;
    }

    public double getOpeningFund() {
        return openingFund;
    }

    public void setOpeningFund(double openingFund) {
        this.openingFund = openingFund;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }


    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double calculateInterest(){
        return 0;
    }
}
