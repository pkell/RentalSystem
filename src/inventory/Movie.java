
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
 
    @Override
    public int getCopies()
    {
        return item.getCopies();
    }
    
    @Override
    public void setCopies(int _copies)
    {
        item.setCopies(_copies);
    }
    
    @Override
    public String getProductID()
    {
        return item.getProductID();
    }

    @Override
    public String getTitle () //get item title 
    { 
       return item.getTitle();
    }
       
    @Override
    public String getItemID()
    {
        return item.getItemID();
    }
 
    @Override
    public int getPriceCode() 
    { 
        return item.getPriceCode(); 
    } 
 
    
    
     @Override
     public boolean rent(double price){
         return true;
     }
}
