package staff;

import users.User;

public class StaffMember extends User {
   
    public StaffMember(String user, String pass){
        super(user);
    }
    
    @Override
    public boolean login(String pass){
        return true;
    }
    
}
