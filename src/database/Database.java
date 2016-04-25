
package database;
import java.util.ArrayList;
import rental.Rental;
import inventory.*;

public class Database implements DatabaseInterface {
        private Item i1 = new Game("0001", "Grand Theft Auto");
        private Item i2 = new Movie("0002", "The Shining");
        ArrayList<Item> it = new ArrayList<Item>();
        
    public Database(){
        it.add(i1);
        it.add(i2);
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
  
    @Override
    public void updateBalance(String username, double amount){
    }
    
    @Override
    public ArrayList<Rental> getRentalDetails(String user){
        ArrayList<Rental> r = new ArrayList<Rental>();
        Rental r1 = new Rental(i1, 2, 2);
        return r;
    }
    
    @Override
    public Item getItemByID(String id){
        for(Item i : it){
            if(i.getItemID().equals(id)){
                return i;
            }
        }
        return null;
    }
}
