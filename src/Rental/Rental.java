package Rental;
import inventory.Item;
/**
 *
 * @author Kamil
 */
public class Rental { 
 private final Item item;
 private int daysRented; 
 
    public Rental(Item i, int _daysRented) //rental for movie
    { 
        item = i; 
        daysRented = _daysRented; 
    }
 
    
    public String getType()
    {
      return item.getType();
    }
    
    public int getDaysRented() //get amount of days the item is being rented for
    { 
        return daysRented; 
    } 
  
    public void setDaysRented(int days)
    {
        daysRented = days;
    }
    
    public Item getItem() //get ITem
    {
        return item;
    }
   
    public void setItem(String ID)
    {
        item.setItemID(ID);
    }
    
    public double getCharge() //get price for item rental 
    { 
        return item.getCharge(daysRented); 
    }

   
    public int getFrequentRenterPoints() 
    { 
        return item.getFrequentRenterPoints(daysRented); 
    } 

}   