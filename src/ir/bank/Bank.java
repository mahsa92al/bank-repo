package ir.bank;

import ir.bank.enumeration.AccountType;

/**
 * @author Mahsa Alikhani m-58
 */
public class Bank {

    Customer[] customers = new Customer[1000];
    static int customerIndex = 0;

    public void addNewAccount(String name, long id, double openingFund, MyDate openingDate, AccountType accountType) {
        Customer customer = findByNationalId(id);
        if (customer == null) {
            customer = addNewCustomer(name, id);
        }
        customer.addNewAccount(openingFund, openingDate, accountType);
    }

    private Customer addNewCustomer(String name, long id) {
        Customer customer = new Customer(id, name);
        customers[customerIndex] = customer;
        customerIndex++;
        return customer;
    }

    private Customer findByNationalId(long id) {
        for (int i = 0; i < customerIndex; i++) {
            if (customers[i].getNationalId() == id) {
                return customers[i];
            }
        }
        return null;
    }

    public void printCustomerAccount(long id) {
        Customer customer = findByNationalId(id);
        if (customer == null) {
            System.out.println("There is no customer whit this ID!");
            return;
        }
        customer.printAccounts();
    }

    public void withDraw(long id, long bankAccount, double money, MyDate currentDate) {
        Customer customer = findByNationalId(id);
        if (customer == null) {
            System.out.println("There is no customer whit this ID!");
            return;
        }
        customer.withDraw(bankAccount, money, currentDate);
    }

    public void deposit(long id, long bankAccount, double money, MyDate currentDate) {
        Customer customer = findByNationalId(id);
        if (customer == null) {
            System.out.println("There is no customer whit this ID!");
            return;
        }
        customer.deposit(bankAccount, money, currentDate);
    }

    public void calculateInterest(long id, long bankAccount, MyDate date) {
        Customer customer = findByNationalId(id);
        if (customer == null) {
            System.out.println("There is no customer whit this ID!");
            return;
        }
        customer.calculateInterest(bankAccount, date);
    }

    public void viewTransactions(long id, long bankAccount) {
        Customer customer = findByNationalId(id);
        if (customer == null) {
            System.out.println("There is no customer whit this ID!");
            return;
        }
        customer.viewTransactions(bankAccount);
    }
}
