package staff;

import database.DatabaseAccess;
import users.User;

public class Manager extends User {
    private DatabaseAccess data = DatabaseAccess.getInstance();
    public Manager(String user){
        super(user);
    }
 
    public void addMovie(String id, String name, boolean adult){
        data.addMovie(id, name, adult);
    }
   
    public void addGame(String id, String name, boolean adult){
        data.addGame(id, name, adult);
    }
    
    public void deleteStaff(String user){
        data.deleteStaff(user);
    }
    
}
