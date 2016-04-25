package inventory;

 abstract class Price
 { 
    abstract String getPriceCode(); 
    abstract double getCharge(int daysRented); 
    int getFrequentRenterPoints(int daysRented){ 
    return 2;
    }
} 
class ChildrensPrice extends Price 
{ 
 @Override
 String getPriceCode() 
 { 
    return Item.CHILDRENS; 
 } 
 @Override
 double getCharge(int daysRented){ 
 double result = 1.5; 
 if (daysRented > 3) 
 result += (daysRented - 3) * 1.5; 
 return result; 
 } 

} 

class NewReleasePrice extends Price { 
 @Override
 String getPriceCode() 
 { 
 return Item.NEW_RELEASE; 
 }
 @Override
double getCharge(int daysRented){ 
 return daysRented * 3; 
 } 
int getFrequentRenterPoints(int daysRented) { 
 return (daysRented > 1) ? 20: 1; 
 } 
 
 } 

 class RegularPrice extends Price {   
 @Override
 String getPriceCode() 
 { 
  return Item.REGULAR; 
 } 
 @Override
 double getCharge(int daysRented){ 
 double result = 2; 
 if (daysRented > 2) 
 result += (daysRented - 2) * 1.5; 
 return result; 
 } 
 }

 class ps4Price extends Price
 {
    @Override
    String getPriceCode() 
    { 
       return Item.PS4; 
    } 
    @Override
    double getCharge(int daysRented) // ps4 game = 4e per night and 
    { 
       double result = 4; 
       if (daysRented > 4) 
       result += (daysRented - 4) * 1.5; //discount applied if rented for more than 4 nights 
       return result; 
    } 

    @Override
    public int getFrequentRenterPoints(int daysRented) //if item is rented for more than 1 night 2 renter points are returned.
    { 
        return (daysRented > 1) ? 2: 1; 
    }
 }

 class ps3Price extends Price
 {
    @Override
    String getPriceCode() 
    { 
       return Item.PS3; 
    }  
    @Override
    double getCharge(int daysRented) // ps3 game = 2e per night and 
    { 
       double result = 2; 
       if (daysRented > 2) 
       result += (daysRented - 2) * 1.5; //discount applied if rented for more than 2 nights 
       return result; 
    }
 }

class xboxOnePrice extends Price
 {
    @Override
    String getPriceCode() 
    { 
       return Item.XBOXONE; 
    } 
    @Override
    double getCharge(int daysRented) // xbox one game = 4.50e per night and 
    { 
       double result = 4.5; 
       if (daysRented > 5) 
       result += (daysRented - 5) * 1.5; //discount applied if rented for more than 5 nights 
       return result; 
    }
 }