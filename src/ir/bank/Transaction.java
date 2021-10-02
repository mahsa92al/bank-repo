package ir.bank;

import ir.bank.enumeration.TransactionType;

/**
 * @author Mahsa Alikhani m-58
 */
public class Transaction {

    private TransactionType transactionType;
    private double amount;
    private MyDate transactionDate;

    public Transaction(TransactionType transactionType, double amount, MyDate transactionDate) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MyDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(MyDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType=" + transactionType +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
