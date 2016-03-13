
package users;

public class Customer extends User {
    
    public Customer(String user, String password){
        super(user);
    }
    
    @Override
    public boolean login(String user, String pass){
        return true;
    }
    
    @Override
    public String getUsername(){
        return username;
    }
    
}
