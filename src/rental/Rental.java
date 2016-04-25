/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;
import inventory.Item;
/**
 *
 * @author Kamil
 */
public class Rental { 
 private Item item;
 private int daysRented; 
 private double price;
 
    public Rental(Item i, int _daysRented, double _price) //rental for movie
    { 
        item = i; 
        daysRented = _daysRented; 
        price = _price;
        
    }
 
    
    public int getDaysRented() //get amount of days the item is being rented for
    { 
        return daysRented; 
    } 
  
    
    public Item getItem() //get ITem
    {
        return item;
    }
   
    
    public double getPrice() //get price for item rental 
    { 
        return price;
    }

}   