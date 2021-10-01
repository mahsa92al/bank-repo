package ir.bank;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Saving extends Account{

    private final double interestPerMonth = 0.1;


    @Override
    public double calculateInterest() {
        Saving saving = new Saving();
        return interestPerMonth * saving.getFund() + saving.getFund();
    }
}
