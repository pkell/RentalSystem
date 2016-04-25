/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Rental.Rental;
import inventory.Item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kamil
 */
public class RentPanel extends Panel{
private PanelManager pm;
private final JPanel panel;
private final JTextField txb_itemID;
private final JButton btn_add, btn_back;
private final JLabel lbl_itemID;
private final Helper help = Helper.getInstance();
public RentPanel() 
{
    panel = new JPanel();
    panel.setLayout(null);
    
    lbl_itemID = new JLabel("Item ID: ");
    panel.add(lbl_itemID);
    lbl_itemID.setBounds (195, 95, 50, 40);
    
    txb_itemID = new JTextField (0);
    panel.add (txb_itemID);
    txb_itemID.setBounds (245, 95, 120, 25);
    
    btn_add = new JButton();
    btn_add.setBounds (245, 125, 120, 30);
        btn_add.setText("Add to basket");
        panel.add(btn_add);
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               btnAddActionPerformed(evt);
            }
        }); 
        
        
    btn_back = new JButton();
    btn_back.setBounds (245, 155, 120, 25);
        btn_back.setText("Back");
        panel.add(btn_back);   
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                pm.getPanelFromFactory(2);
            }
        });  
}

private void btnAddActionPerformed(ActionEvent evt) {                           
        //get the product from the database and check if there are any copies left 
        String id;
        Item p = null;
        id = txb_itemID.getText();
        p = help.getItemByID(id);     
        
        if(p != null)
        {
         if(p.getAvailablibilty() == true)                //item not available   
         {             
            String[] choices = {"1","2","3","4","5","6", "7"}; //max rental days = 7
            String input = (String) JOptionPane.showInputDialog(null, "How many nights ?", //get days of rental 
            "Pick amount of nights to rent the product", JOptionPane.QUESTION_MESSAGE, null, choices,
            choices[0]); // Initial choice     
            Rental r1 = new Rental(p , Integer.parseInt(input)); //create new rental for picked amount of days
            help.addToBasket(r1);                                  //add the rental to the basket
             JOptionPane.showMessageDialog(null, "Item has been added to your basket"); 
             //add product to your basket 
         }
         else
             JOptionPane.showMessageDialog(null, "Sorry, this item is not available at the moment.");
        }
        else 
            JOptionPane.showMessageDialog(null, "Sorry, this item doesn't exist in our system");
   
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
