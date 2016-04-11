package staff;

import users.User;

public class Manager extends User {
    
    public Manager(String user){
        super(user);
    }
    
    @Override
    public boolean login(String pass){
        return true;
    }
    
}
