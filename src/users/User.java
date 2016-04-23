
package users;


public abstract class User {
    protected String username;
    protected double balance;
    
    public User(String user){
        username = user;
    }
    
    public String getUsername(){
        return username;
    }
    public double getBalance(){
        return balance;
    }
}
