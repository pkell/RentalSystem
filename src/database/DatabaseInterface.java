
package database;

import inventory.Item;
import inventory.Product;

public interface DatabaseInterface {
    public boolean canCustomerLogin(String user, String pass);
    public double getCustomerBalance(String user);
    public void updateBalance(String username, double amount);
    public boolean canStaffLogin(String user, String pass);
    public boolean canManagerLogin(String user, String pass);
    public Item getItemByTitle(String title, String type);
    public Item getItemByID(String id);
    public void setProduct(Product p);
    public Item getItemByTitleAndPlatform(String title, String platform);
}
