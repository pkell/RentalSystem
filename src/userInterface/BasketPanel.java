/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Rental.Rental;
import inventory.Item;
import inventory.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import users.Customer;

/**
 *
 * @author Kamil
 */
public class BasketPanel extends Panel{
    
    private JLabel h;
    private JLabel f;
    private PanelManager pm;
    private JButton btn_rent, btn_back;
    private Customer cust;
    public BasketPanel(){
    

    panel = new JPanel(); 
        
        cust = new Customer("Kamil");
      
        
        panel.setLayout (null);
        btn_rent = new JButton("Rent");
        btn_back = new JButton("Back");
        h = new JLabel(cust.header());
        f = new JLabel(cust.footer());
        
        panel.add(h);
        panel.add(f);
        panel.add(btn_rent);
        panel.add(btn_back);
        
        h.setBounds (260, 25, 300, 400);
        f.setBounds (260, 265, 300, 200);
        btn_rent.setBounds(260, 600, 100, 50);
        btn_back.setBounds(260, 700, 100, 50);
        
          btn_rent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if customer has sufficinet funds
                //charge for the rental and take money from the accont
                //add rentals to the database 
                //empty the basket/empty rentals
                //add rental points to account
                }
                });
          
          btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(2);
                }
                });
          
 }
    @Override
    public JPanel sendToWindow()
    { 
	return this.panel; 
    }
	
    @Override
    public void setPanelManager(PanelManager pm)
    {
	this.pm = pm;
    }
    
    
}
