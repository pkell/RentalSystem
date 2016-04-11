package staff;

import users.User;
import database.Database;

public class StaffMember extends User {
    private Database data = new Database();
   
    public StaffMember(String user){
        super(user);
    }
    
    @Override
    public boolean login(String pass){
        return data.canLogin(this.username, pass);
    }
    
}
