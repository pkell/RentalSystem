
package users;


public abstract class User {
    protected String username;
    
    public User(String user){
        username = user;
    }
    
    public abstract boolean login(String user, String pass);
    public abstract String getUsername();
}
