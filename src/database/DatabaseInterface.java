
package database;

import inventory.Item;
import inventory.Product;

public interface DatabaseInterface {
    public boolean canCustomerLogin(String user, String pass);
    public double getCustomerBalance(String user);
    public void updateBalance(String username, double amount);
    public boolean canStaffLogin(String user, String pass);
    public boolean canManagerLogin(String user, String pass);
    public Item getItemByTitle(String title);
    public Item getItemByID(String id);
    public void createProduct(String ID, String title, String type, String genre, int copies);
    public void setProduct(Product p);
    
}
