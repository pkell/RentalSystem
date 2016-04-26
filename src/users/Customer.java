package users;

import database.DatabaseAccess;
import paymentAPI.Payment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import inventory.Item;
import rental.Rental;

public class Customer extends User {
    private DatabaseAccess data = DatabaseAccess.getInstance();
    private boolean adult;
    private HashMap<Item, Integer> basket =  new HashMap<Item, Integer>();
    private ArrayList<Rental> rentals = new ArrayList<Rental>();
    private double balance;
    
    public Customer(String user){
        super(user);
        getBalanceFromDatabase();
        getRentalDetails();
        setAdultStatus();
    }
    
    public void setAdultStatus(){
        adult = data.isCustomerAdult(username);
    }
    
    public boolean getAdultStatus(){
        return adult;
    }
    
    public String displayBasket(){
        String result = "";
        for (Map.Entry<Item, Integer> entry : basket.entrySet())
        {
            result+= entry.getKey().getProductName() + " (Days: " + entry.getValue() + ")\n";
        }
        return result;
    }
    public void getRentalDetails(){
        data.getRentalDetails(username);
    }
    
    public String displayRentals(){
        String result = "";
        for(Rental r : rentals){
            result += r.getItem().getProductName() + " (Days: " + r.getDaysRented() + ")\n";
        }
        return result;
    }
    
    public void emptyBasket(){
        basket.clear();
    }
    public boolean rentItems(){
        boolean ok = true;
        for (Map.Entry<Item, Integer> entry : basket.entrySet())
        {
            ok = entry.getKey().rent(entry.getValue());
            if(ok){
                rentals.add(new Rental(entry.getKey(), entry.getValue(), entry.getKey().calcCost(entry.getValue())));
                basket.remove(entry.getKey(), entry.getValue());
            }
        }
        return ok;
    }
    public double calcBasket(){
        double result = 0.0;
        for (Map.Entry<Item, Integer> entry : basket.entrySet())
        {
            result += entry.getKey().calcCost(entry.getValue());
        }   
        return result;
    }
    
    public boolean addToBasket(Item i, int days){
        boolean in = false;
        for (Map.Entry<Item, Integer> entry : basket.entrySet())
        {
            if(entry.getKey().getItemID().equals(i.getItemID())){
                in = true;
            }
        }
        if(!in){
            basket.put(i, days);
        }
        return in;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double bal){
        balance = bal;
    }
    
    public void getBalanceFromDatabase(){
        balance = data.getCustomerBalance(username);
    }
    
    public boolean topUp(double amount){
        if(Payment.acceptPayment(amount)){
            balance += amount;
            data.updateBalance(username, amount);
            return true;
        }
        return false;
    }
   
}