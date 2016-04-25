
package inventory;

public class Movie extends Item {
 
    private Item item;
    private boolean available;
    private boolean bluRay;
    
    public Movie(Product p1, String item, String priceCode, boolean _bluRay) 
    {
        super(p1, item, priceCode);
        available = true;
        bluRay = _bluRay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getBluRay() {
        return bluRay;
    }

    public void setBluRay(boolean bluRay) {
        bluRay = bluRay;
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
 
 
    public String getPriceCode() 
    { 
        return item.getPriceCode(); 
    } 
 
    
    
     @Override
     public boolean rent(double price){
         return true;
     }
}
