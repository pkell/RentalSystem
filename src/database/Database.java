
package database;

import inventory.Item;
import inventory.Product;
import java.util.ArrayList;

public class Database implements DatabaseInterface {
 
    private ArrayList<Product> products = new ArrayList();
    private ArrayList<Item> items = new ArrayList();
    public Database(){
        Product p1 = new Product("1", "Spiderman", "Movie", "Fantasy", 0);
        Product p2 = new Product("2", "Avengers", "Movie", "Fantasy", 2);
        Product p3 = new Product("3", "Fifa 16", "Game", "PS3", "Sport", 3);
        Product p4 = new Product("4", "Call of Duty", "Game", "Shooter", 1);
        Product p5 = new Product("5", "GTA V", "Game", "Acion", 5);
        Product p6 = new Product("5", "GTA V", "Movie", "Acion", 1);
        Product p7 = new Product("7", "Fifa 16", "Game", "PS4", "Sport", 1);
        items.add(new Item(p1, "1.1", "Regular")); //regular price
        items.add(new Item(p1, "1.2", "Regular"));
        items.add(new Item(p1, "1.3", "Regular"));
        items.add(new Item(p2, "2.1", "New Release")); // new release
        items.add(new Item(p2, "2.2", "New Release"));
        items.add(new Item(p3, "3.1", "PS4")); //ps4
        items.add(new Item(p3, "3.2", "Xbox One")); //xboxone
        items.add(new Item(p3, "3.3", "PS4"));
        items.add(new Item(p4, "4.1", "Xbox One")); //xboxOne
        items.add(new Item(p5, "5.1", "PS3")); //ps3
        items.add(new Item(p5, "5.2", "PS4"));
        items.add(new Item(p5, "5.3", "PS3"));
        items.add(new Item(p5, "5.4", "PS4"));
        items.add(new Item(p5, "5.5", "PS3"));  
        items.add(new Item(p6, "6.1", "Regular"));
        items.add(new Item(p7, "7.1", "PS4")); 
    }
    
    @Override
    public boolean canCustomerLogin(String user, String pass){
        return true;
    }
    
    
     @Override
    public boolean canStaffLogin(String user, String pass){
        return true;
    }
    
     @Override
    public boolean canManagerLogin(String user, String pass){
        return true;
    }
    
    @Override
    public double getCustomerBalance(String user){
        return 5.00;
    }
  
    @Override
    public void updateBalance(String username, double amount){
    }
    
    @Override
   public Item getItemByTitle(String title, String type)
   {
       int i = 0;
       Item p = null;
       
       while(i < items.size())
       {
          if(items.get(i).getTitle().equalsIgnoreCase(title) && items.get(i).getType().equalsIgnoreCase(type))
             p = items.get(i);                   
             i++; 
       }
        return p;
   }
   
    @Override
   public Item getItemByID(String ID)
   {
       int i = 0;
       Item p = null;    
       while(i < items.size())
       {
          if(items.get(i).getItemID().trim().equals(ID))
             p = items.get(i);                   
             i++; 
       }
        return p;
   }
   
     @Override
     public Item getItemByTitleAndPlatform(String title, String platform)
     {
       int i = 0;
       Item p = null;    
       while(i < items.size())
       {
          if(items.get(i).getTitle().equalsIgnoreCase(title) && items.get(i).getPriceCode().equalsIgnoreCase(platform))
             p = items.get(i);                   
             i++; 
       }
        return p;
     }
            
     @Override
     public void setProduct(Product p)
     {
         
     }
}
