/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author nrage
 */
public class CustomerPanel extends Panel {
    private JLabel jtest;
    private JPanel panel;
    private final JButton btn_rentProdcut, btn_topUp, btn_searchProducts, btn_logout, btn_basket, btn_checkRentedItems;
    private final JLabel lbl_welcome, lbl_custName, lbl_rentalPoints, lbl_points, lbl_currentBalance, lbl_balance, lbl_accType, lbl_acc;
    private PanelManager pm;
    private final Helper help = Helper.getInstance();

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
        lbl_welcome = new JLabel ("Welcome: ");
        lbl_custName = new JLabel (help.getCustName());
        lbl_points = new JLabel("Frequent rental points: ");
        lbl_rentalPoints = new JLabel (Integer.toString(help.getTotalFrequentRenterPoints()));
        lbl_balance = new JLabel("Current Balance: ");
        lbl_currentBalance = new JLabel(Double.toString(help.getBalance()));
        lbl_acc = new JLabel("Account type: ");
        lbl_accType = new JLabel(help.getAccountType());

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
        panel.add (lbl_welcome);
        panel.add (lbl_custName);
        panel.add (lbl_points);
        panel.add (lbl_rentalPoints);
        panel.add (lbl_balance);
        panel.add (lbl_currentBalance);
        panel.add (lbl_acc);
        panel.add (lbl_accType);
        //set component bounds (only needed by Absolute Positioning)
        btn_rentProdcut.setBounds (240, 70, 200, 50);
        btn_searchProducts.setBounds (240, 125, 200, 50);
        btn_topUp.setBounds (240, 180, 200, 50);
        btn_checkRentedItems.setBounds (240, 235, 200, 50);
        btn_basket.setBounds (240, 290, 200, 50);
        btn_logout.setBounds (240, 345, 200, 50);
        lbl_welcome.setBounds (5, 5, 60, 25);
        lbl_custName.setBounds (65, 5, 135, 25);
        lbl_points.setBounds(5, 30, 130, 25);
        lbl_rentalPoints.setBounds(135, 30, 135, 25);
        lbl_balance.setBounds(5, 55, 130, 25);
        lbl_currentBalance.setBounds(135, 55, 135, 25);
        lbl_acc.setBounds(5, 80, 130, 25);
        lbl_accType.setBounds(135, 80, 135, 25);
       
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
                pm.getPanelFromFactory(4);
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
