
package inventory;
import paymentAPI.Payment;

public class Movie extends Item {
    
    private final int maxDays = 2;
    private final int pricePerDay = 3;
    
    public Movie(String item, String product, boolean adult){
        super(item, product, adult);
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
