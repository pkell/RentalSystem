
package userInterface;

import staff.*;
import users.*;
import database.*;
import inventory.*;

public class Helper {
    private static Helper help = new Helper();
    private DatabaseInterface dbConn;
    private Customer cust = null;
    private StaffMember staff = null;
    private Manager manager = null;
    
    private Helper(){
        
    }
   public static Helper getInstance(){
      return help;
   }
   
   public void setDbConn(DatabaseInterface dbConn)
   {
	this.dbConn = dbConn;
    }
   
   public boolean addToBasket(Item i, int days){
       return cust.addToBasket(i, days);
   }
   
   public Item getItemByID(String id){
       return dbConn.getItemByID(id);
   }
   
   public String displayBasket(){
       return cust.displayBasket();
   }
   
   public void emptyBasket(){
       cust.emptyBasket();
   }
   
   public boolean rentItems(){
       return true; //cust.rentItems();
   }
   
   public boolean canCustomerLogin(String user, String pass){
       if(dbConn.canCustomerLogin(user, pass)){
           getCustomerDetails(user);
           return true;
       }
       return false;
   }
   
   public boolean canStaffLogin(String user, String pass){
       if(dbConn.canStaffLogin(user, pass)){
           getStaffDetails(user);
           return true;
       }
       return false;
   }

   public boolean canManagerLogin(String user, String pass){
       
        if(dbConn.canManagerLogin(user, pass)){
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
}
  