
package userInterface;

import staff.*;
import users.*;
import database.*;
import inventory.*;

public class Helper {
    private static Helper help = new Helper();
    private DatabaseAccess dba;
    private Customer cust = null;
    private StaffMember staff = null;
    private Manager manager = null;
    
    private Helper(){
        
    }
   public static Helper getInstance(){
      return help;
   }
   
   public void deleteUser(String user){
       staff.deleteUser(user);
   }
   
   public void removeItem(String itemId){
       dba.removeItem(itemId);
   }
   
   public void deleteStaff(String user){
       manager.deleteStaff(user);
   }
   
   public void addMovie(String id, String name, boolean adult){
       manager.addMovie(id, name, adult);
   }
 
   public void addGame(String id, String name, boolean adult){
       manager.addGame(id, name, adult);
   }
   
   public void setDbAccess(DatabaseAccess dba)
   {
	this.dba = dba;
    }
   
   public boolean addToBasket(Item i, int days){
       return cust.addToBasket(i, days);
   }
   
   public String displayRentals(){
       return cust.displayRentals();
   }
   
   public double calcBasket(){
       return cust.calcBasket();
   }
   
   public Item getItemByID(String id){
       return dba.getItemByID(id);
   }
   
   public String displayBasket(){
       return cust.displayBasket();
   }
   
   public void emptyBasket(){
       cust.emptyBasket();
   }
   
   public boolean rentItems(){
       if(cust.getBalance() <= calcBasket()){
           return false;
       }
       if(cust.rentItems()){
            return true;
       }
       return false;
   }
   
   public boolean canCustomerLogin(String user, String pass){
       if(dba.canCustomerLogin(user, pass)){
           getCustomerDetails(user);
           return true;
       }
       return false;
   }
   
   public boolean canStaffLogin(String user, String pass){
       if(dba.canStaffLogin(user, pass)){
           getStaffDetails(user);
           return true;
       }
       return false;
   }

   public boolean canManagerLogin(String user, String pass){
       
        if(dba.canManagerLogin(user, pass)){
           getManagerDetails(user);
           return true;
       }
       return false;  
   }
   
   public void getCustomerDetails(String user){
       cust = new Customer(user);
   }

   public void getStaffDetails(String user){
       staff = new StaffMember(user);
   }
 
   public void getManagerDetails(String user){
       manager = new Manager(user);
   }
   
   public double getCustomerBalance(){
       return cust.getBalance();
   }
 
   public void setBalance(double bal){
        cust.setBalance(bal);
    }
   
   public boolean topUp(double amount){
       return cust.topUp(amount);
   }
   
   public String getCustName(){
       return cust.getUsername();
   }
   
   public String getStaffName(){
       return staff.getUsername();
   }
   
   public double getBalance(){
       return cust.getBalance();
   }
   
   public boolean isCustomerAdult(){
       return cust.getAdultStatus();
   }
   
   public void grantAdultAccess(String user){
       staff.grantAdultAccess(user);
   }
}
  