
package database;

public interface DatabaseInterface {
    public boolean canLogin(String user, String pass);
    public double getCustomerBalance(String user);
    public void updateBalance(String username, double amount);
}
