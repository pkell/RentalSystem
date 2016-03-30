
package inventory;

import rentable.Rentable;

public abstract class Item implements Rentable {
    private String itemID;
    private String productID;
    
    public Item(String item, String product){
        itemID = item;
        productID = product;
    }
    
    public String getItemID(){
        return itemID;
    }
    
    public String getProductID(){
        return productID;
    }
    
    @Override
    public abstract boolean rent(double price);
      
}
