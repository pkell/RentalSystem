
package database;

public interface DatabaseInterface {
    public boolean canCustomerLogin(String user, String pass);
    public double getCustomerBalance(String user);
    public void updateBalance(String username, double amount);
    public boolean canStaffLogin(String user, String pass);
    public boolean canManagerLogin(String user, String pass);
    
}
