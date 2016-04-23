
package database;

import inventory.Item;
import inventory.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Database implements DatabaseInterface {
 
    private ArrayList<Product> products = new ArrayList();
    private ArrayList<Item> items = new ArrayList();
    public Database(){
        Product p1 = new Product("1", "Spiderman", "Movie", "Fantasy", 0);
        Product p2 = new Product("2", "Avengers", "Movie", "Fantasy", 2);
        Product p3 = new Product("3", "Fifa 16", "Game", "Sport", 3);
        Product p4 = new Product("4", "Call of Duty", "Game", "Shooter", 1);
        Product p5 = new Product("5", "GTA V", "Game", "Acion", 5);
        items.add(new Item(p1, "1.1", 0)); //regular price
        items.add(new Item(p1, "1.2", 0));
        items.add(new Item(p1, "1.3", 0));
        items.add(new Item(p2, "2.1", 2)); // new release
        items.add(new Item(p2, "2.2", 2));
        items.add(new Item(p3, "3.1", 4)); //ps4
        items.add(new Item(p3, "3.2", 4));
        items.add(new Item(p3, "3.3", 4));
        items.add(new Item(p4, "4.1", 5)); //xboxOne
        items.add(new Item(p5, "5.1", 3)); //ps3
        items.add(new Item(p5, "5.2", 3));
        items.add(new Item(p5, "5.3", 3));
        items.add(new Item(p5, "5.4", 3));
        items.add(new Item(p5, "5.5", 3));  
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
  
    public void updateBalance(String username, double amount){
    }
    
   public Item getItemByTitle(String title)
   {
       int i = 0;
       Item p = null;
       
       while(i < items.size())
       {
          if(items.get(i).getTitle().trim().equalsIgnoreCase(title))
             p = items.get(i);                   
             i++; 
       }
        return p;
   }
   
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
   
   public void createProduct(String ID, String title, String type, String genre, int copies)
   {
       products.add(new Product(ID, title, type, genre, copies));
       for(int n = 0; n < copies; n++)
       {
           String id = Integer.toString(n);
           items.add(new Item(ID, title, type, genre, copies, id, 2));                   
       }
   }
     
     @Override
     public void setProduct(Product p)
     {
         
     }
}
