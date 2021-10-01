package ir.bank;

/**
 * @author Mahsa Alikhani m-58
 */
public class Bank {

    Customer[] customers = new Customer[1000];
    static int customerIndex = 0;

    public void addNewAccount(String name, long id, double openingFund, MyDate openingDate) {
        for (int i = 0; i < 1000; i++) {
            if (customers[i].getNationalId() == id) {
                System.out.println("This account exists before!");
            } else {
                customers[customerIndex] = new Customer();
                customers[customerIndex].setName(name);
                customers[customerIndex].setNationalId(id);
                customers[customerIndex].addNewAccountBank(openingDate, openingFund);
                customerIndex++;
                System.out.println("New account is created successfully");
                break;
            }

        }
    }

    public void printCustomerAccount(long id) {
        for (int i = 0; i < customerIndex; i++) {
            if (id != customers[i].getNationalId()) {
                System.out.println("There is no customer whit this ID!");
            }
        }
        for (int j = 0; j < customerIndex; j++) {
            if (id == customers[j].getNationalId()) {
                customers[j].printAccounts();
            }
            break;
        }
    }

    public void withDraw(long id, long bankAccount, double money){
        for(int i = 0; i < customerIndex; i++){
            if(customers[i].getNationalId() != id){
                System.out.println("There is no customer with this " + id);
            }
        }
        for(int i = 0; i < customerIndex; i++){
            if(customers[i].getNationalId() == id){
                customers[i].withDraw(bankAccount, money);
            }
        }
    }
    public void deposit(long id, long bankAccount, double money){
        for(int i = 0; i < customerIndex; i++){
            if(customers[i].getNationalId() != id){
                System.out.println("There is no customer with this " + id);
            }
        }
        for(int i = 0; i < customerIndex; i++){
            if(customers[i].getNationalId() == id){
                customers[i].deposit(bankAccount, money);
            }
        }
    }

    public void calculateInterest(long id, long bankAccount){
        for (int i = 0; i < customerIndex; i++) {
            if(customers[i].getNationalId() != id){
                System.out.println("There is no customer with this " + id);
            }
        }
        for (int i = 0; i < customerIndex; i++) {
            if(customers[i].getNationalId() == id){
                customers[i].calculateInterest(bankAccount);
            }
        }
    }
}
