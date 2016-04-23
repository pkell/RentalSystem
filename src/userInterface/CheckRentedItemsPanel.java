/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import users.Customer;

/**
 *
 * @author Kamil
 */
public class CheckRentedItemsPanel extends Panel{
    private PanelManager pm;
    private JList jList_rentedItems;
    private JButton btn_back;
    private Customer cust;
    
    public CheckRentedItemsPanel()
    {
        panel = new JPanel();
        cust = new Customer("Kamil");
         //construct preComponents
        String[] jList_rentedItemsItems = {"                                                          Items Rented\n"+
                                                cust.displayRentals(), " "};
     
        //construct components
        jList_rentedItems = new JList (jList_rentedItemsItems);
        btn_back = new JButton("Back");

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (667, 366));
        panel.setLayout (null);

        //add components
        panel.add (jList_rentedItems);
        panel.add (btn_back);

        //set component bounds (only needed by Absolute Positioning)
        jList_rentedItems.setBounds (115, 80, 435, 175);
        btn_back.setBounds(115, 500, 100, 20);
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
