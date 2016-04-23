/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Rental.Rental;
import inventory.*;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import users.Customer;
/**
 *
 * @author nrage
 */
public class CustomerPanel extends Panel {
    private JButton btn_rentProdcut;
    private JButton btn_topUp;
    private JButton btn_searchProducts;
    private JButton btn_logout;
    private JButton btn_basket;
    private JButton btn_checkRentedItems;
    private JLabel jcomp5;
    private JLabel lbl_custName;
    private PanelManager pm;
    private Helper help = Helper.getInstance();
    
    public CustomerPanel() {
        //construct components
        panel = new JPanel();
        
      
        //construct components
        btn_rentProdcut = new JButton ("Rent Product");
        btn_topUp = new JButton ("Top Up");
        btn_searchProducts = new JButton ("Search Products");
        btn_logout = new JButton ("Logout");
        btn_basket = new JButton ("Basket");
        btn_checkRentedItems = new JButton ("Check rented Items");
        jcomp5 = new JLabel ("Welcome: ");
        lbl_custName = new JLabel (help.getCustName());

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (667, 366));
        panel.setLayout (null);

        //add components
        panel.add (btn_rentProdcut);
        panel.add (btn_topUp);
        panel.add (btn_searchProducts);
        panel.add (btn_basket);
        panel.add (btn_logout);
        panel.add (btn_checkRentedItems);
        panel.add (jcomp5);
        panel.add (lbl_custName);

        //set component bounds (only needed by Absolute Positioning)
        btn_rentProdcut.setBounds (240, 70, 200, 50);
        btn_searchProducts.setBounds (240, 125, 200, 50);
        btn_topUp.setBounds (240, 180, 200, 50);
        btn_checkRentedItems.setBounds (240, 235, 200, 50);
        btn_basket.setBounds (240, 290, 200, 50);
        btn_logout.setBounds (240, 345, 200, 50);
        jcomp5.setBounds (5, 5, 60, 25);
        lbl_custName.setBounds (65, 5, 135, 25);
       
        btn_topUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(6);
                }
                });
        btn_rentProdcut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(3);
                }
                });
        btn_basket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(5);
                }
                });
        btn_searchProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(7);
                }
                });
        btn_checkRentedItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(8);
                }
                });
        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(1);
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
