
package database;

public class Database implements DatabaseInterface {
    
    public Database(){
        
    }
    @Override
    public boolean canCustomerLogin(String user, String pass){
        return true;
    }
    
    
     @Override
    public boolean canStaffLogin(String user, String pass){
        return true;
    }
    
     @Override
    public boolean canManagerLogin(String user, String pass){
        return true;
    }
    
    @Override
    public double getCustomerBalance(String user){
        return 5.00;
    }
  
    public void updateBalance(String username, double amount){
    }
}
