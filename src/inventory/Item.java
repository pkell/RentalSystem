
package inventory;

import rentable.Rentable;

public class Item implements Rentable {
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
    public boolean rent(double price){
        return true;
    }
}
