
package inventory;

import rentable.Rentable;

public abstract class Item implements Rentable {
    private String itemID;
    private String productName;
    
    public Item(String item, String name){
        itemID = item;
        productName = name;
    }
    
    public String getItemID(){
        return itemID;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public abstract double calcCost(int days);
    @Override
    public abstract boolean rent(int days);
      
}
