
package inventory;

import rentable.Rentable;

public class Item extends Product implements Rentable {
    
    public static final int CHILDRENS = 1; 
    public static final int REGULAR = 0; 
    public static final int NEW_RELEASE = 2;  
    
    public static final int PS3 = 3; 
    public static final int PS4 = 4; 
    public static final int XBOXONE = 5;
   
    
    private String itemID;
    private Product product; 
    private int priceCode;
 

   
    
    public Item(String product, String title, String type, String genre, int copies, String item, int _priceCode)
    {
        super(product, title, type, genre, copies);
        itemID = item;
        setPriceCode(priceCode);
    }

    public Item(Product p1, String item, int priceCode) 
    {
        product = p1;
        itemID = item;
        setPriceCode(priceCode);
    }
    
    public String getTitle()
    {
     return product.getTitle();
    }
    
    public int getCopies()
    {
        return product.getCopies();
    }
    
    public void setCopies(int _copies)
    {
     product.setCopies(_copies);
    }
    
    public String getGenre()
    {
     return product.getGenre();   
    }
    
    public String getProductID()
    {
        return product.getProductID();
    }

       
    public String getItemID()
    {
        return itemID;
    }
    
    
    public int getPriceCode() 
    { 
        return price.getPriceCode(); 
    }
    
    
    public void setProductID(String ID)
    {
        product.setProductID(ID);
    }

    public void setTitle(String title) //get item title 
    { 
       product.setTitle(title);
    }
       
    public void setItemID(String ID)
    {
        itemID = ID;
    }
    
    public String getType()
    {
        return product.getType();
    }
      
    public void setPriceCode(int arg) 
    {  
            switch (arg) 
            {
                case REGULAR: 
                price = new RegularPrice(); 
                break; 
                case CHILDRENS: 
                price = new ChildrensPrice(); 
                break; 
                case NEW_RELEASE: 
                price = new NewReleasePrice(); 
                break; 
                case PS3: 
                price = new ps3Price(); 
                break; 
                case PS4: 
                price = new ps4Price(); 
                break; 
                case XBOXONE: 
                price = new xboxOnePrice(); 
                break; 
                default: 
                throw new IllegalArgumentException("Incorrect Price Code"); 
            }   
    } 
    
   private Price price; 
 
 
 
    public double getCharge(int daysRented) //gets charge for the Item rented
    { 
       return price.getCharge(daysRented); 
    } 
  
    public int getFrequentRenterPoints(int daysRented) //gets rental points for the Item rented
    { 
        return price.getFrequentRenterPoints(daysRented); 
    } 

    @Override
    public boolean rent(double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
      
}
