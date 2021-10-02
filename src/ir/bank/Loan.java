package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.TransactionType;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Loan extends Account{

    private final double interestPerMonth = 0.18;
    private final double loanAmount = 3000000;
    private final int loanDuration = 36;

    public Loan(MyDate openingDate, double openingFund, AccountType accountType) {
        super(openingDate, openingFund, accountType);
    }

    public void calculateInterest(MyDate date) {
         double interest = (interestPerMonth * loanAmount)/loanDuration;
        setFund(interest + getFund());
        addNewTransaction(interest, date, TransactionType.INTEREST);
    }
}
