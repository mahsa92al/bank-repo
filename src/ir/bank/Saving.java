package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.TransactionType;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Saving extends Account{

    private final double interestPerMonth = 0.1;

    public Saving(MyDate openingDate, double openingFund, AccountType accountType) {
        super(openingDate, openingFund, accountType);
    }

    public void calculateInterest(MyDate date) {
        double interest = interestPerMonth * getFund();
        setFund(interest + getFund());
        addNewTransaction(interest, date, TransactionType.INTEREST);
    }
}
