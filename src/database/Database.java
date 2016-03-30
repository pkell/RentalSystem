
package database;

public class Database implements DatabaseInterface {
    
    public Database(){
        
    }
    @Override
    public boolean canLogin(String user, String pass){
        return true;
    }
    
    @Override
    public double getCustomerBalance(String user){
        return 5.00;
    }
  
    public void updateBalance(String username, double amount){
    }
}
