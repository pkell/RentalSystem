/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inventory.Item;
import rental.Rental;
import java.util.ArrayList;


public class DatabaseAccess {
    private DatabaseInterface dbconn;
    private static DatabaseAccess dba = new DatabaseAccess();
    
    private DatabaseAccess(){
    }
    
    public void setDbconn(DatabaseInterface dbconn){
        this.dbconn = dbconn;
    }
    
    public void removeItem(String itemId){
        dbconn.removeItem(itemId);
    }
    
    public void addMovie(String id, String name, boolean adult){
        dbconn.addMovie(id, name, adult);
    }
    
    public void addGame(String id, String name, boolean adult){
        dbconn.addGame(id, name, adult);
    }
    
   public void deleteStaff(String user){
       dbconn.deleteStaff(user);
   }
   public void grantAdultAccess(String user){
       dbconn.grantAdultAccess(user);
   }
   
   public boolean canCustomerLogin(String user, String pass){
       return dbconn.canCustomerLogin(user, pass);
   }
   
   public boolean canStaffLogin(String user, String pass){
       return dbconn.canStaffLogin(user, pass);
   }
   
   public boolean canManagerLogin(String user, String pass){
       return dbconn.canManagerLogin(user, pass);
   }
   
   public void deleteUser(String user){
       dbconn.deleteUser(user);
   }
   
   public Item getItemByID(String id){
       return dbconn.getItemByID(id);
   }
   
   public static DatabaseAccess getInstance(){
       return dba;
   } 
 
    public double getCustomerBalance(String user){
        return dbconn.getCustomerBalance(user);
    }
  
    public void updateBalance(String username, double amount){
        dbconn.updateBalance(username, amount);
    }
    

    public ArrayList<Rental> getRentalDetails(String user){
        return dbconn.getRentalDetails(user);
    }
    
    public boolean isCustomerAdult(String user){
        return dbconn.isCustomerAdult(user);
    }

}
