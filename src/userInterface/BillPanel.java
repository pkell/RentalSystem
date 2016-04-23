/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Rental.Rental;
import inventory.Item;
import inventory.Product;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import users.Customer;

/**
 *
 * @author Kamil
 */
public class BillPanel extends Panel {
    
    private JLabel h;
    private JLabel f;
    private PanelManager pm;
    public BillPanel(){
    

    panel = new JPanel(); 
        
        Customer cust = new Customer("Kamil");

        
        panel.setLayout (null);
        h = new JLabel(cust.header());
        f = new JLabel(cust.footer());
        
        panel.add(h);
        panel.add(f);
        
        h.setBounds (260, 25, 200, 400);
        f.setBounds (260, 265, 300, 200);
        
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
