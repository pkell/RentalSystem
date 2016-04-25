
package inventory;

public class Game extends Item {
  
    private Item item;
    private String platform;
    private boolean available;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
  
    public Game(Product p1, String item, String priceCode, String _console) 
    {
        super(p1, item, priceCode);
        available = true;
        platform = _console;
    }
     
    public void setPlatform(String console)
    {
        platform = console;
    }
    
    public String getPlatform()
    {
        return platform;
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
    public String getPriceCode() 
    { 
        return item.getPriceCode(); 
    } 
    
 
    
     @Override
     public boolean rent(double price){
         return true;
     }
}
