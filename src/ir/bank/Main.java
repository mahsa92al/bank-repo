package ir.bank;

import ir.bank.enumeration.AccountType;
import ir.bank.enumeration.ManagerMenu;

import java.util.Scanner;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Customer customer = new Customer();
        String choice;
        do{
            ManagerMenu.showManagementMenu();
            do{
                choice = scanner.next();
            }while(!choice.matches("[1-9]+"));
            switch (Integer.parseInt(choice)){
                case 1:
                    String name;
                    do {
                        System.out.println("Customer Name:");
                        System.out.println("Name:");
                        name = scanner.next();
                    } while (!name.matches("[a-zA-Z]+"));

                    String openingFund;
                    do {
                        System.out.println("Opening fund:");
                        openingFund = scanner.next();
                    } while (!openingFund.matches("^[0-9]+(.|//)?[0-9]?$"));

                    System.out.println("Customer national ID:");
                    long nationalId = scanner.nextLong();/////add regex here
                    System.out.println("Day:");
                    int day = scanner.nextInt();
                    System.out.println("Month:");
                    int month = scanner.nextInt();
                    System.out.println("Year:");
                    int year = scanner.nextInt();
                    AccountType.showAccountTypes();
                    System.out.println("Account type:");
                    String accountType = scanner.next();
                    MyDate openingDate = new MyDate(day, month, year);
                    bank.addNewAccount(name, nationalId, Double.parseDouble(openingFund), openingDate,accountType);
                    break;
                case 2:
                    System.out.println("Customer national ID:");
                    nationalId = scanner.nextLong();/////add regex here
                    management.printCustomerAccount(nationalId);
                    break;
                case 3:
                    System.out.println("Enter customer national ID:");
                    nationalId = scanner.nextLong(); //// add regex here
                    System.out.println("Enter Bank account:");
                    long bankAccount = scanner.nextLong(); //// add regex here
                    System.out.println("Enter amount of money:");
                    double amountOfMoney = scanner.nextDouble(); //// add regex here
                    management.withDraw(nationalId, bankAccount, amountOfMoney);
                    break;
                case 4:
                    System.out.println("Enter customer national ID:");
                    nationalId = scanner.nextLong(); //// add regex here
                    System.out.println("Enter Bank account:");
                    bankAccount = scanner.nextLong(); //// add regex here
                    System.out.println("Enter amount of money:");
                    amountOfMoney = scanner.nextDouble(); //// add regex here
                    management.deposit(nationalId, bankAccount, amountOfMoney);
                    break;
                case 5:
                    System.out.println("Enter customer national ID:");
                    nationalId = scanner.nextLong(); //// add regex here
                    System.out.println("Enter Bank account:");
                    bankAccount = scanner.nextLong(); //// add regex here
                    management.calculateInterest(nationalId, bankAccount);
                    break;
                case 6:
                    System.out.println("Enter customer national ID:");
                    nationalId = scanner.nextLong(); //// add regex here
                    System.out.println("Enter Bank account:");
                    bankAccount = scanner.nextLong(); //// add regex here
                    management.viewTransactions(nationalId, bankAccount);
                    break;
                case 7:
                    System.out.println("***goodbye***");
                    break;
                default:
                    System.out.println("Invalid value");
            }
        }while (Integer.parseInt(choice) != 7);

    }
}
