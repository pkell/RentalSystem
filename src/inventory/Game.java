
package inventory;

import paymentAPI.Payment;

public class Game extends Item {
    
    private final int maxDays = 10;
    private final int pricePerDay = 1;
    
     public Game(String item, String name){
         super(item, name);
    }   
     
     @Override
     public boolean rent(int days){
         if(days <= maxDays){
             if(Payment.acceptPayment(days * pricePerDay)){
                 return true;
             }
         }
         return false;
     }
     
     @Override
     public double calcCost(int days){
         return days * pricePerDay;
     }
}
