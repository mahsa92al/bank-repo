package ir.bank.enumeration;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public enum AccountType {
    CHECKING("1. Checking account"),
    SAVING("2. Saving account"),
    LOAN("3. Loan account");

    private String expression;

    AccountType(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public  static void showAccountTypes(){
        for (AccountType item:AccountType.values()) {
            System.out.println(item.getExpression());
        }
    }

}
