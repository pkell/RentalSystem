
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
    public void deleteUser(String user);
    public boolean isCustomerAdult(String user);
    public void grantAdultAccess(String user);
    public void removeItem(String itemId);
    public void addMovie(String id, String name, boolean adult);
    public void addGame(String id, String name, boolean adult);
    public void deleteStaff(String user);
    
}
