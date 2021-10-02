package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.TransactionType;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Checking extends Account{
    final double fee = 700;

    public Checking(MyDate openingDate, double openingFund, AccountType accountType) {
        super(openingDate, openingFund, accountType);
    }

    @Override
    public void withdraw(double money, MyDate currentDate) {
        if(money < 2000000 && getFund() > money + fee){
            super.withdraw(money, currentDate);
            setFund(getFund() - fee);
            addNewTransaction(fee, currentDate, TransactionType.FEES);
        }else {
            System.out.println("Amount of the money must be under 2000000 T!");
        }

    }
}
