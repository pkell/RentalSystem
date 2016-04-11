
package inventory;

public class Game extends Item {
    
    private final int maxDays = 10;
    private final int pricePerDay = 1;
    
     public Game(String item, String product){
         super(item, product);
    }   
     
     @Override
     public boolean rent(double price){
         return true;
     }
}
