package users;

import database.Database;
import paymentAPI.Payment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import inventory.Item;
import rental.Rental;

public class Customer extends User {
    private Database data = new Database();
    private HashMap<Item, Integer> basket =  new HashMap<Item, Integer>();
    private ArrayList<Rental> rentals = new ArrayList<Rental>();
    private double balance;
    
    public Customer(String user){
        super(user);
        getBalanceFromDatabase();
        getRentalDetails();
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
    
    public void emptyBasket(){
        basket.clear();
    }
    public boolean rentItems(int days){
        /*for(Item i : basket){
            if(i.rent(days)){ 
            }
        }*/
        return true;
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