/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Joel
 */
public class CustomerDecorator implements ICustomer {
    private Customer aCustomer;
    public CustomerDecorator(Customer cust)
    {
        aCustomer= cust;
    }
    
    public double getDiscount()
    {
        return aCustomer.getDiscount();
    }
    
}
