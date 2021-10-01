package ir.bank;

/**
 * @author Mahsa Alikhani m-58 - pset HW4 - Q#6 - Bank management
 */
public class Management {





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

    public void viewTransactions(long id, long bankAccount){
        for (int i = 0; i < customerIndex; i++) {
            if(customers[i].getNationalId() != id){
                System.out.println("There is no customer with this " + id);
            }
        }
        for (int i = 0; i < customerIndex; i++) {
            if(customers[i].getNationalId() == id){
                customers[i].viewTransactions(bankAccount);
            }
        }
    }
}
