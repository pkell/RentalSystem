/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inventory.Item;


public class DatabaseAccess {
    private DatabaseInterface dbconn;
    
    public DatabaseAccess(DatabaseInterface db){
        dbconn = db;
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
}
