package staff;

import users.User;
import database.DatabaseAccess;

public class StaffMember extends User {
    private DatabaseAccess data = DatabaseAccess.getInstance();
   
    public StaffMember(String user){
        super(user);
    }
    
    public void deleteUser(String user){
        data.deleteUser(user);
    }
    
    public void grantAdultAccess(String user){
        data.grantAdultAccess(user);
    }

    
}
