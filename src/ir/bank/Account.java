package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.TransactionType;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Account {

    private MyDate openingDate;
    private double openingFund;
    private long accountNumber;
    private AccountType accountType;
    private double fund;
    private Transaction[] transactions = new Transaction[50];
    private int transactionIndex = 0;

    public Account(MyDate openingDate, double openingFund, AccountType accountType) {
        this.openingDate = openingDate;
        this.openingFund = openingFund;
        this.accountType = accountType;
        this.accountNumber = getRandomNumber();
        this.fund = openingFund;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 999999 - 100000 + 1) + 100000;
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

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
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

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public int getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(int transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public void withdraw(double money, MyDate currentDate){
        if(getFund() > money){
            setFund(getFund() - money);
            addNewTransaction(money, currentDate, TransactionType.WITHDRAW);
        }else{
            System.out.println("Fund is noe enough!");
        }
    }

    public void deposit(double money, MyDate currentDate){
        setFund(getFund() + money);
        addNewTransaction(money, currentDate, TransactionType.DEPOSIT);
    }

    public Transaction addNewTransaction(double money, MyDate currentDate, TransactionType transactionType) {
        Transaction transaction = new Transaction(transactionType, money, currentDate);
        transactions[transactionIndex] = transaction;
        transactionIndex++;
        return transaction;
    }

    public void showTransactions(){
        for (int i = 0; i < transactionIndex; i++) {
            System.out.println(transactions[i]);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "openingDate=" + openingDate +
                ", openingFund=" + openingFund +
                ", accountNumber=" + accountNumber +
                ", accountType=" + accountType +
                ", fund=" + fund +
                '}';
    }
}
