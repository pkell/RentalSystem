
package userInterface;

import Rental.Rental;
import staff.*;
import users.*;
import database.*;
import inventory.Item;
import java.util.Vector;

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

   
   public void addRental(Rental r)
   {
       cust.addRental(r);
   }
  
   public String header()
   {
       return cust.header();
   }
   
   public String footer()
   {
       return cust.footer();
   }
    public Item getItemByTitle(String title)
    {
        return dbConn.getItemByTitle(title);
     }
    
    public Item getItemByID(String id)
    {
        return dbConn.getItemByID(id);
     }
    
    public double getTotalCharge() 
    {
        return cust.getTotalCharge();  
    }
    
    public void emptyBasket()
    {
      cust.emptyBasket();    
    }
    
    public void addToBasket(Rental r)
    {
        cust.addToBasket(r);
    }
    
    public Vector getBasket()
    {
     return cust.getBasket();   
    }
    
    public int getTotalFrequentRenterPoints()
    {
        return cust.getTotalFrequentRenterPoints();
    }
    
    public int getFrequentRenterPoints()
    {
        return cust.getFrequentRenterPoints();
    }
    
    public void setFrequentRenterPoints(int p)
    {
        cust.setFrequentRenterPoints(p);
    }
    
    public void createProduct(String ID, String title, String type, String genre, int copies)
    {
        //dbConn.createProduct(ID, title, type, genre, 0);
    }
}
