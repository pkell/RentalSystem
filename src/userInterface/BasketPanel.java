/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Rental.Rental;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kamil
 */
public class BasketPanel extends Panel{
    
    private final JLabel f, lbl_basket;
    private PanelManager pm;
    private final JButton btn_rent, btn_back, btn_clear;
    private Helper help = Helper.getInstance();
    private Vector basket;
    public BasketPanel(){
    
    basket = help.getBasket();
    panel = new JPanel(); 
        
        panel.setLayout (null);
        btn_rent = new JButton("Rent");
        btn_back = new JButton("Back");
        btn_clear = new JButton("Empty the Basket");
        lbl_basket = new JLabel("<html><h1>Items in basket<h1>");
        f = new JLabel(display());
        
        panel.add(lbl_basket);
        panel.add(f);
        panel.add(btn_rent);
        panel.add(btn_back);
        panel.add(btn_clear);
        
        lbl_basket.setBounds (260, 50, 400, 25);
        f.setBounds (260, 75, 400, 400);
        btn_rent.setBounds(260, 350, 100, 25);
        btn_back.setBounds(260, 375, 100, 25);
        btn_clear.setBounds(260, 400, 200, 25);
        
        btn_rent.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {       
                double currentBalance = help.getBalance();
                if(!basket.isEmpty())
                {
                   if(help.getBalance() >= help.getTotalCharge())//check if customer has sufficinet funds
                   {  
                     help.setBalance(currentBalance - help.getTotalCharge());
                     addRental();
                     if(help.getTotalFrequentRenterPoints() >= 20)
                     {
                      JOptionPane.showMessageDialog(null, "Well done, you collected 20 frequent renter points\n "
                                                     + "your account is upgraded to Gold Account"); 
                      help.setAccountType("Gold");
                     }
                     if(help.getTotalFrequentRenterPoints() >= 50)
                     {
                      JOptionPane.showMessageDialog(null, "Well done, you collected 20 frequent renter points\n "
                                                     + "your account is upgraded to Platinum Account"); 
                      help.setAccountType("Platinum");
                     }
                    }
                     else 
                      JOptionPane.showMessageDialog(null, "Don't have sufficent credit to rent the items\n"
                          + "Pease top up your account");   
                 
                }
                else
                  JOptionPane.showMessageDialog(null, "The basket it empty, please add items to the basket"); 
             }
        });
          
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(2);
                }
                });
          
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help.emptyBasket();        //empty basket
                pm.getPanelFromFactory(5); //refresh page
                }
                });
          
 }
    public String display()
    {
        Enumeration rentals1 = basket.elements(); 
        String result = "<html>";
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); 
            //show figures for each rental 
            result += String.valueOf(each.getItem().getType()) + " - " + String.valueOf(each.getItem().getPriceCode()) + " - " + String.valueOf(each.getItem().getTitle())+ ",&nbsp;&nbsp;" + 
            String.valueOf(each.getItem().getGenre()) + ",&nbsp;&nbsp;Nights: &nbsp;&nbsp;"+ String.valueOf(each.getDaysRented()) + "&nbsp;&nbsp;,Price: " +
            String.valueOf(each.getCharge() + " euro<BR><BR>");    
        }
            result += "<html><P>You owe: <EM>" + String.valueOf(help.getTotalCharge()) + 
            " euro</EM><P>\n"; 
      return result;
    }
     
    public void addRental()
    {
        int result = 0;
        Enumeration rentals1 = basket.elements(); 
        while (rentals1.hasMoreElements()) 
        { 
            Rental each = (Rental) rentals1.nextElement(); 
            if(each.getItem().getAvailablibilty() == true)
            {
                help.addRental(each);
                each.getItem().setAvailability(false);
                each.getItem().setCopies(each.getItem().getCopies() - 1);   
                result += each.getFrequentRenterPoints();
            }
            else
                JOptionPane.showMessageDialog(null, "Sorry " + each.getItem().getTitle() + " is no longer available");                  
        }
        JOptionPane.showMessageDialog(null, "Items rented, well done !\n"
                                      + "On this rental you earned " + result + " frequent renter points");
        help.emptyBasket(); 
        pm.getPanelFromFactory(5);
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
