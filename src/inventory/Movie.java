
package inventory;

public class Movie extends Item {
 
    private Item item;
 
    
    public Movie(String product, String title, String type, String genre,int copies, String item, int priceCode)
    { 
        super(product, title, type, genre, copies, item, priceCode);
      
    } 

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
 
    public int getCopies()
    {
        return item.getCopies();
    }
    
    public void setCopies(int _copies)
    {
        item.setCopies(_copies);
    }
    
    public String getProductID()
    {
        return item.getProductID();
    }

    public String getTitle () //get item title 
    { 
       return item.getTitle();
    }
       
    public String getItemID()
    {
        return item.getItemID();
    }
 
    public int getPriceCode() 
    { 
        return item.getPriceCode(); 
    } 
 
    
    
     @Override
     public boolean rent(double price){
         return true;
     }
}
