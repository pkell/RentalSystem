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
public class GoldMembership extends CustomerDecorator {
    GoldMembership(Customer c)
    {
        super(c);
    }
    
    public double getDiscount()
    {
        return 0.2;
    }
    
}
