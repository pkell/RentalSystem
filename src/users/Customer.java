
package users;

import database.Database;
import paymentAPI.Payment;

public class Customer extends User {
    private Database data = new Database();
    private double balance;
    
    public Customer(String user){
        super(user);
        getBalanceFromDatabase();
    }
    
    @Override
    public boolean login(String pass){
        return data.canLogin(this.username, pass);
    }
    
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double bal){
        balance = bal;
    }
    
    public void getBalanceFromDatabase(){
        balance = data.getCustomerBalance(username);
    }
    
    public boolean topUp(double amount){
        if(Payment.acceptPayment(amount)){
            balance += amount;
            data.updateBalance(username, amount);
            return true;
        }
        return false;
    } 
   
}
