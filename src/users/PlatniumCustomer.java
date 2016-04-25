/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import users.Customer;

/**
 *
 * @author Joel
 */
public class PlatniumCustomer extends Customer{
    private double discount=0.2;
    public PlatniumCustomer(String user) {
        super(user);
    }
    
    public double getDiscountRate()
            {
              return discount;  
            }
            
    
}
