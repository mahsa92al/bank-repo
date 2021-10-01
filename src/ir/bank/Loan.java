package ir.bank;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Loan extends Account{

    private final double interestPerMonth = 0.18;
    private final double loanAmount = 3000000;
    private final int loanDuration = 36;

    @Override
    public double calculateInterest() {
        return (interestPerMonth * loanAmount)/loanDuration;
    }
}
