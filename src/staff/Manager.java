package staff;

import users.User;

public class Manager extends User {
    
    public Manager(String user, String pass){
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
