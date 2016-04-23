
package inventory;

public class Game extends Item {
  
    private Item item;
 
    
     public Game(String product, String title, String item, String type, int copies, String genre, int price)
     {
        super(product, title, item, type, copies, genre, price);
 
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
