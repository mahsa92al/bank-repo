package ir.bank.enumeration;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public enum ManagerMenu {
    ADD("1. Add new customer"),
    ACCOUNTS("2. View accounts"),
    WITHDRAW("3. Withdraw"),
    DEPOSIT("4. Deposit"),
    CALCULATE("5. Calculate interests"),
    TRANSACTIONS("6. View Transactions"),
    EXIT("7. Exit");

    private String expression;

    ManagerMenu(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public static void showManagementMenu(){
        System.out.println("***Manager Menu***");
        for (ManagerMenu item:ManagerMenu.values()) {
            System.out.println(item.getExpression());
        }
    }
}
