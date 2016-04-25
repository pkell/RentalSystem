
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
        String result = "<html><H1>Rentals for <EM>" + getName() + "</EM></H1>\n"; 
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
     
    public void addToBasket(Item p)
    {
        String[] choices = {"1","2","3","4","5","6", "7"}; //max rental days = 7
        String input = (String) JOptionPane.showInputDialog(null, "How many nights ?", //get days of rental 
        "Pick amount of nights to rent the product", JOptionPane.QUESTION_MESSAGE, null, choices,
        choices[0]); // Initial choice    
        Rental r = new Rental(p, Integer.parseInt(input));
        basket.addElement(r);                                  //add the rental to the basket
        JOptionPane.showMessageDialog(null, "Item has been added to your basket"); 
    }
        
    public void askForRental(Item p)
    {
        int n;
        displayProductInfo(p);
        if(p.getAvailablibilty() == true)                //item available   
        {  
            String id = p.getItemID();
            if(!checkIfInBasket(id))
            { 
                n = JOptionPane.showConfirmDialog(null,"Would you like to add this product to your basket ?"
                , " ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION)
                {
                    addToBasket(p);    
                }
            }
            else 
              JOptionPane.showMessageDialog(null, "This item is already in your basket");  
        }
        else 
         JOptionPane.showMessageDialog(null, "This item is not available at the moment"); 
    }
    
    
    public void rent()
    {
        double currentBalance = getBalance();
        if(!basket.isEmpty())
        {
            if(getBalance() >= getTotalCharge())//check if customer has sufficinet funds
            {  
                setBalance(currentBalance - getTotalCharge());
                int result = 0;
                Enumeration rentals1 = basket.elements(); 
                while (rentals1.hasMoreElements()) 
                { 
                  Rental each = (Rental) rentals1.nextElement(); 
                  if(each.getItem().getAvailablibilty() == true)
                  {
                    addRental(each);
                    each.getItem().setAvailability(false);
                    each.getItem().setCopies(each.getItem().getCopies() - 1);   
                    result += each.getFrequentRenterPoints();
                  }
                  else
                   JOptionPane.showMessageDialog(null, "Sorry " + each.getItem().getTitle() + " is no longer available");                  
                }
                JOptionPane.showMessageDialog(null, "Items rented, well done !\n"
                                      + "On this rental you earned " + result + " frequent renter points");
                emptyBasket(); 
                accountUpgrade();
            }
            else 
                JOptionPane.showMessageDialog(null, "Don't have sufficent credit to rent the items\n"
                          + "Pease top up your account");   
                 
        }
        else
          JOptionPane.showMessageDialog(null, "The basket it empty, please add items to the basket"); 
    }
    
    public void accountUpgrade()
    {
        if((!help.getAccountType().equals("Platinum")) && getTotalFrequentRenterPoints() >= 50)
            {
                JOptionPane.showMessageDialog(null, "Well done, you collected 50 frequent renter points\n "
                                                     + "your account is upgraded to Platinum Account"); 
                setAccountType("Platinum");
            }
        if(help.getAccountType().equals("Silver") && getTotalFrequentRenterPoints() >= 20)
            {
                JOptionPane.showMessageDialog(null, "Well done, you collected 20 frequent renter points\n "
                                                     + "your account is upgraded to Gold Account"); 
                 setAccountType("Gold");
            }        
    }
    
    public String displayBasket()
    {
        Enumeration rentals1 = basket.elements(); 
        String result = "<html>";
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); 
            //show figures for each rental 
            result += String.valueOf(each.getItem().getType()) + " - " + String.valueOf(each.getItem().getPriceCode()) + " - " + String.valueOf(each.getItem().getTitle())+ ",&nbsp;&nbsp;" + 
            String.valueOf(each.getItem().getGenre()) + ",&nbsp;&nbsp;Nights: &nbsp;&nbsp;"+ String.valueOf(each.getDaysRented()) + "&nbsp;&nbsp;,Price: " +
            String.valueOf(each.getCharge() + " euro<BR><BR>");    
        }
            result += "<html><P>You owe: <EM>" + String.valueOf(getTotalCharge()) + 
            " euro</EM><P>\n"; 
      return result;
    }
    
    public void getProductByID(String id)
    {
        Item p = null;
        p = help.getItemByID(id);          
        if(p != null)
        {
         if(p.getAvailablibilty() == true)                //item not available   
         {             
            if(!checkIfInBasket(id))
            {
                addToBasket(p);
            }
            else
             JOptionPane.showMessageDialog(null, "This item is already in your basket");   
         }
         else
             JOptionPane.showMessageDialog(null, "Sorry, this item is not available at the moment.");
        }
        else 
            JOptionPane.showMessageDialog(null, "Sorry, this item doesn't exist in our system");
    }
    // display items by console 
    public void getProductByTitle(String title, String type, String c)
    {
        Item p = null;
        p = help.getItemByTitle(title, type); //get type by title and type
        if(p != null && (p.getType().trim().equalsIgnoreCase(type))) //check if item of this title and type exists 
        {
            if(p.getType().equals("Movie")) //if movie selected
            {
               askForRental(p);
            }
            else //if game selected
            {
                if(p.getConsole().equals(c))  //checks if selected item is for this console
                {
                     askForRental(p);        //if true ask for rental
                }   
                else                            //if false search for the item for that console
                {
                    p = help.getItemByTitleAndPlatform(title, c);
                    if(p != null)              //if found ask for rental
                    {
                        askForRental(p);
                    }
                    else                      //if not found display message
                        JOptionPane.showMessageDialog(null, "No item for this console"); 
                }
            }
        }
        else  //if item of this title and type doesnt exist display message
         JOptionPane.showMessageDialog(null, "No Item Found");   
        //display the details of the product in a dialog box
    }
    
    public boolean login(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
