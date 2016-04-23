/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Rental.Rental;
import inventory.Item;
import inventory.Product;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import users.Customer;

/**
 *
 * @author Kamil
 */
public class RentPanel extends Panel{
private PanelManager pm;
private JPanel panel;
private JTextField txb_itemID;
private JButton btn_add, btn_back;
private Customer cust;
private JLabel lbl_itemID;
private Helper help = Helper.getInstance();
public RentPanel() 
{
    panel = new JPanel();
    panel.setLayout(null);
    cust = new Customer("Kamil");
    
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
        String id = "";
        Item p = null;
        id = txb_itemID.getText();
        p = help.getItemByID(id);
        int copies = 0;     
        if(p != null)
        {
            copies = p.getCopies();
         if(copies > 0)                //item not available   
         {             
            String[] choices = {"1","2","3","4","5","6", "7"}; //max rental days = 7
            String input = (String) JOptionPane.showInputDialog(null, "How many nights ?", //get days of rental 
            "Pick amount of nights to rent the product", JOptionPane.QUESTION_MESSAGE, null, choices,
            choices[0]); // Initial choice
            
            Rental r1 = new Rental(p , Integer.parseInt(input)); //create new rental for picked amount of days
            cust.addRental(r1);                                  //add the rental to the basket
            p.setCopies(copies - 1);
             JOptionPane.showMessageDialog(null, "Item has been added to your basket"); 
             JOptionPane.showMessageDialog(null, cust.header() + "\n" + cust.footer()); 
             //add product to your basket 
         }
         else
             JOptionPane.showMessageDialog(null, "Sorry, this item is not available.");
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
