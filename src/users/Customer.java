
package users;

import database.Database;
import paymentAPI.Payment;
import Rental.Rental;
import java.util.Enumeration;
import java.util.Vector;

public class Customer extends User {
    private final Database data = new Database();
    private double balance;
    private final Vector rentals = new Vector(); //basket of rented items 
    private String accType;
    private int rentalPoints;
    
    
    public Customer(String user){
        super(user);
        getBalanceFromDatabase();
        getRentalPoints();
 
    }
    

    public int getRentalPoints()
    {
      return rentalPoints;    
    }
    
    public String getAccountType()
    {
      return accType;    
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getName()
    {
        return username;                 //returns customers username
    }
    
    public void addRental(Rental arg) {    
     rentals.addElement(arg);            //add rental to the basket
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
            result += String.valueOf(each.getItem().getType()) + " - " + String.valueOf(each.getItem().getTitle())+ ": " + 
            String.valueOf(each.getCharge()) + " euro\n"; 
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
        rentalPoints += getTotalFrequentRenterPoints();
        return result; 
    } 

    
    
    private double getTotalCharge() 
    { 
        double result = 0; 
        Enumeration rentals1 = rentals.elements(); 
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); //for each rental price is added to result
            result += each.getCharge(); 
        } 
        return result; //whole price is returned
    } 

    private int getTotalFrequentRenterPoints()
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

    public boolean login(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
