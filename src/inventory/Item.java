
package inventory;

import rentable.Rentable;

public class Item extends Product implements Rentable { 
    public static final String CHILDRENS = "Childrens"; 
    public static final String REGULAR = "Regular"; 
    public static final String NEW_RELEASE = "New Release";  
    
    public static final String PS3 = "PS3"; 
    public static final String PS4 = "PS4"; 
    public static final String XBOXONE = "Xbox One";
    
    private String itemID;
    private Product product; 
    private boolean available;  
    private Price price; 
    
    public Item(String product, String title, String type, String genre, int copies, String item, String priceCode)
    {
        super(product, title, type, genre, copies);
        itemID = item;
        setPriceCode(priceCode);
        available = true;
    }

    public Item(Product p1, String item, String priceCode) 
    {
        product = p1;
        itemID = item;
        setPriceCode(priceCode);
        available = true;
    }
    
    public String getConsole()
    {
        return product.getConsole();
    }
    
    public void setPriceCode(String arg)
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
    
    public String getPriceCode() 
    { 
        return price.getPriceCode(); 
    }
    
    public boolean getAvailablibilty()
    {
      return available;    
    }
    
    public void setAvailability(boolean b)
    {
      available = b;    
    }
    
    @Override
    public String getTitle()
    {
     return product.getTitle();
    }
    
    @Override
    public int getCopies()
    {
        return product.getCopies();
    }
    
    @Override
    public void setCopies(int _copies)
    {
     product.setCopies(_copies);
    }
    
    @Override
    public String getGenre()
    {
     return product.getGenre();   
    }
    
    @Override
    public String getProductID()
    {
        return product.getProductID();
    }

       
    public String getItemID()
    {
        return itemID;
    }
 
    
    @Override
    public void setProductID(String ID)
    {
        product.setProductID(ID);
    }

    @Override
    public void setTitle(String title) //get item title 
    { 
       product.setTitle(title);
    }
       
    public void setItemID(String ID)
    {
        itemID = ID;
    }
    
    @Override
    public String getType()
    {
        return product.getType();
    }
 
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
