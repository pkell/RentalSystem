
package inventory;


public class Movie extends Item {
    
    private final int maxDays = 2;
    private final int pricePerDay = 3;
    
    public Movie(String item, String product){
        super(item, product);
    }

     @Override
     public boolean rent(double price){
         return true;
     }
}
