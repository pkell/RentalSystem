package userInterface;

import staff.*;
import users.*;
import database.*;
import inventory.Item;

public class Helper {
    private static final Helper help = new Helper();
    private DatabaseInterface dbConn;
    private Customer cust = null;
    private StaffMember staff = null;
    private Manager manager = null;
    
  
   private Helper()
   {
        
   }
   
   public static Helper getInstance(){
      return help;
   }
   
   public void setDbConn(DatabaseInterface dbConn)
   {
	this.dbConn = dbConn;
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

   public String header()
   {
       return cust.header();
   }
   
    public void emptyBasket()
    {
      cust.emptyBasket();    
    }

    public Item getItemByTitle(String title, String type)
    {
        return dbConn.getItemByTitle(title, type);
     }
    
    public Item getItemByID(String id)
    {
        return dbConn.getItemByID(id);
     }
    
    public int getTotalFrequentRenterPoints()
    {
        return cust.getTotalFrequentRenterPoints();
    }
    
    public String getAccountType()
    {
        return cust.getAccountType();
    }
    
    public void askForRental(Item p)
    {
      cust.askForRental(p);
    }
    
    public void rent()
    {
        cust.rent();
    }

    public String displayBasket()
    {
        return cust.displayBasket();
    }
    
    public void getProductByID(String id)
    {
        cust.getProductByID(id);
    }
    
    public void getProductByTitle(String title, String type, String c)
    {
        cust.getProductByTitle(title, type, c);
    }
    
    public Item getItemByTitleAndPlatform(String title, String c)
    {
       return dbConn.getItemByTitleAndPlatform(title,c); 
    }
}