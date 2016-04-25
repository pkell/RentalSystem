
package users;

import database.Database;
import paymentAPI.Payment;
import Rental.Rental;
import inventory.Item;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import userInterface.Helper;

public class Customer extends User {
    private final Database data = new Database();
    private double balance;
    private final Vector rentals = new Vector(); //vector of rented items
    private final Vector basket = new Vector();
    private String accType;
    private int frequentRenterPoints;
    private final Helper help = Helper.getInstance();
    
    
    public Customer(String user){
        super(user);
        getBalanceFromDatabase();
        getFrequentRenterPoints();
        accType = "Silver";
    }
    

    public int getFrequentRenterPoints()
    {
      return frequentRenterPoints;    
    }
    
    public void setFrequentRenterPoints(int p)
    {
         frequentRenterPoints = p;
    }
    
    public String getAccountType()
    {
      return accType;    
    }
    
    public void setAccountType(String a)
    {
        accType = a;
    }
    public double getBalance(){
        return balance;
    }
    
    public String getName()
    {
        return username;                 //returns customers username
    }
    
    public void addRental(Rental arg) 
    {    
     rentals.addElement(arg);            //add to rented items
    }
    
    public void addToBasket(Rental arg)
    { 
      basket.addElement(arg);            //add to basket
    }
    
    public String displayRentals()
    {
      String result = "";
      for(int i = 0; i < rentals.size(); i++)
       result += rentals.get(i);
      return result;
    }
    
    
    public String header()
    {
     Enumeration rentals1 = rentals.elements(); 
        String result = "<html><H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n"; 
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); 
            //show figures for each rental 
            result += "ID: " + String.valueOf(each.getItem().getItemID()) + " - " +String.valueOf(each.getItem().getType()) + " - " + String.valueOf(each.getItem().getPriceCode())  
                   +" - "+ String.valueOf(each.getItem().getTitle())+ ": "  
                   +String.valueOf(each.getCharge()) + " euro<BR>\n"; 
        }
        return result;
    }
    
     public String footer() 
     { 
        String result = "";
        //add footer lines 
        result += "<html><P>You owe: <EM>" + String.valueOf(getTotalCharge()) + 
        " euro</EM><P>\n"; 
        result += "On this rental you earned " + 
        String.valueOf(getTotalFrequentRenterPoints()) + 
        " frequent renter points"; 
        frequentRenterPoints += getTotalFrequentRenterPoints();
        return result; 
    } 

    public Vector getBasket()
    {
        return basket;
    }
    
    public void emptyBasket()
    {
      basket.clear();
    }
    
    public double getTotalCharge() 
    { 
        double result = 0; 
        Enumeration rentals1 = basket.elements(); 
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); //for each rental price is added to result
            result += each.getCharge(); 
        } 
        return result; //whole price is returned
    } 

    public int getTotalFrequentRenterPoints()
    { 
        int result = 0; 
        Enumeration rentals1 = rentals.elements(); 
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); //for each rental renter points are added to result
            result += each.getFrequentRenterPoints(); 
        } 
        return result; //whole amount of renter points is returned;
    }   
    
    public void setBalance(double bal){
        balance = bal;
    }
    
    public void getBalanceFromDatabase(){
        balance = data.getCustomerBalance(username);
    }
    
    public boolean topUp(double amount){
        if(Payment.acceptPayment(amount)){
            balance += amount;
            data.updateBalance(username, amount);
            return true;
        }
        return false;
    } 

     public boolean checkIfInBasket(String id)
    {
        boolean in = false;
        Enumeration rentals1 = basket.elements(); 
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); 
            if(each.getItem().getItemID().equals(id))
            {
                in = true;    
            }
        }
        return in;
    }
     
    public void displayProductInfo(Item p)
    {
        JOptionPane.showMessageDialog(null, "Product ID: " + p.getProductID()+"\n"+ 
                       "Item ID: " + p.getItemID() + "\n"+
                       "Price per night: " + p.getCharge(1) + "\n"+
                       "Title: " + p.getTitle()+"\n"+
                       "Type: "+ p.getType() + "\n" +
                       "Genre: " + p.getGenre() + "\n"+ 
                       "Available Copies: " + p.getCopies()+ "\n");
    }
     
    public void createRental(Item p)
    {
        String[] choices = {"1","2","3","4","5","6", "7"}; //max rental days = 7
        String input = (String) JOptionPane.showInputDialog(null, "How many nights ?", //get days of rental 
        "Pick amount of nights to rent the product", JOptionPane.QUESTION_MESSAGE, null, choices,
        choices[0]); // Initial choice    
        Rental r = new Rental(p, Integer.parseInt(input));
        help.addToBasket(r);                                  //add the rental to the basket
        JOptionPane.showMessageDialog(null, "Item has been added to your basket"); 
    }
        
    public boolean login(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
