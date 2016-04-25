
package database;

import java.util.ArrayList;
import rental.Rental;
import inventory.Item;

public interface DatabaseInterface {
    public boolean canCustomerLogin(String user, String pass);
    public double getCustomerBalance(String user);
    public void updateBalance(String username, double amount);
    public boolean canStaffLogin(String user, String pass);
    public boolean canManagerLogin(String user, String pass);
    public ArrayList<Rental> getRentalDetails(String user);
    public Item getItemByID(String id);
    
}
