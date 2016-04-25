/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Rental.Rental;
import inventory.Item;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kamil
 */
public class SearchPanel extends Panel{
    private final JTextField txb_Title;
    private final JLabel jcomp2;
    private final JLabel jcomp3;
    private final JLabel jcomp4;
    private final JComboBox jcb_Type;
    private final JButton btn_Search, btn_back;
    private PanelManager pm;
    private final Helper help = Helper.getInstance();
    private Vector basket;
    public SearchPanel() {
        
        panel = new JPanel();
        //construct preComponents
        String[] jcb_TypeItems = {"Movie", "Game"};

        basket = help.getBasket();
        //construct components
        txb_Title = new JTextField (0);
        jcomp2 = new JLabel ("Search for Item");
        jcomp3 = new JLabel ("Title: ");
        jcomp4 = new JLabel ("Type: ");
        jcb_Type = new JComboBox (jcb_TypeItems);
        btn_Search = new JButton ("Search");
        btn_back = new JButton();
        
        //adjust size and set layout
        panel.setPreferredSize (new Dimension (667, 366));
        panel.setLayout (null);

        //add components
        panel.add (txb_Title);
        panel.add (jcomp2);
        panel.add (jcomp3);
        panel.add (jcomp4);
        panel.add (jcb_Type);
        panel.add (btn_Search);
        panel.add (btn_back);

        //set component bounds (only needed by Absolute Positioning)
        txb_Title.setBounds (245, 95, 100, 25);
        jcomp2.setBounds (250, 45, 90, 25);
        jcomp3.setBounds (210, 95, 35, 25);
        jcomp4.setBounds (210, 125, 35, 25);
        jcb_Type.setBounds (245, 125, 100, 25);
        btn_Search.setBounds (245, 155, 100, 25);
        btn_back.setBounds (245, 185, 100, 25);
        
        
        btn_Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        }); 
        
        btn_back.setText("Back");
        panel.add(btn_back);   
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                pm.getPanelFromFactory(2);
            }
        }); 
    }

    
  
        
    private void btnAddActionPerformed(ActionEvent evt)
    {
        String title, type;
        Item p = null;
        title = txb_Title.getText();
        type =  jcb_Type.getSelectedItem().toString();
        p = help.getItemByTitle(title, type);
        int n;
        if(p != null && (p.getType().trim().equalsIgnoreCase(type))) 
        {
         if(p.getType().equals("Movie"))
         {
            help.displayProductInfo(p);
            if(p.getAvailablibilty() == true)                //item available   
            {  
               String id = p.getItemID();
               if(!help.checkIfInBasket(id))
               { 
                n = JOptionPane.showConfirmDialog(null,"Would you like to add this product to your basket ?"
                        , " ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION)
                   help.createRental(p);
                else 
                    JOptionPane.showMessageDialog(null, "Sorry, this item is not available at the moment."); 
               }
               else 
                  JOptionPane.showMessageDialog(null, "This item is already in your basket");  
            }
          }
         else //game
          {
            help.displayProductInfo(p);
            if(p.getAvailablibilty() == true)                //item available   
            {  
               String id = p.getItemID();
               if(!help.checkIfInBasket(id))
               { 
                n = JOptionPane.showConfirmDialog(null,"Would you like to add this product to your basket ?"
                        , " ", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION)
                { 
                    String[] console = {"PS3", "PS4", "XboxOne"};
                    String c = (String) JOptionPane.showInputDialog(null, "Pick platform", //get days of rental 
                    "Pick platform", JOptionPane.QUESTION_MESSAGE, null, console,
                    console[0]); // Initial choice
                    if(p.getPriceCode().equals(c))
                       help.createRental(p);
                    else
                    {
                       p = help.getItemByTitleAndPlatform(title, c);
                       if(p != null)               
                          help.createRental(p);
                       else
                          JOptionPane.showMessageDialog(null, "No item for this console");  
                    }
                }
               }
               else 
                  JOptionPane.showMessageDialog(null, "This item is already in your basket");  
            }
          }
        }
        else 
         JOptionPane.showMessageDialog(null, "No Item Found");   
        //display the details of the product in a dialog box
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
