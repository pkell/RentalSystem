package staff;

import users.User;

public class StaffMember extends User {
   
    public StaffMember(String user, String pass){
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
