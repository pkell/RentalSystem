
package inventory;

import rentable.Rentable;

public abstract class Item implements Rentable {
    private String itemID;
    private String productName;
    private boolean adult;
    
    public Item(String item, String name, boolean adult){
        itemID = item;
        productName = name;
        this.adult = adult;
    }
    
    public String getItemID(){
        return itemID;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public boolean isAdultRated(){
        return adult;
    }
    
    public abstract double calcCost(int days);
    
    @Override
    public abstract boolean rent(int days);
      
}
