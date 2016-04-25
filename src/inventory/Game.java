
package inventory;

public class Game extends Item {
  
    private Item item;
 
    
     public Game(String product, String title, String item, String type, int copies, String genre, String price)
     {
        super(product, title, item, type, copies, genre, price);
 
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
