
package paymentAPI;

public class Payment {
    
    public boolean acceptPayment(String name, String cardNum, String ccv, double amount){
        return true;
    }
 
    // Overloaded for testing application
    public static boolean acceptPayment(double amount){
        return true;
    }
}
