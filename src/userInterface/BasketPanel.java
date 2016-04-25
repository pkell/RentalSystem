/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    public BasketPanel(){
    
    panel = new JPanel(); 
        
        panel.setLayout (null);
        btn_rent = new JButton("Rent");
        btn_back = new JButton("Back");
        btn_clear = new JButton("Empty the Basket");
        lbl_basket = new JLabel("<html><h1>Items in basket<h1>");
        f = new JLabel(help.displayBasket());
        
        panel.add(lbl_basket);
        panel.add(f);
        panel.add(btn_rent);
        panel.add(btn_back);
        panel.add(btn_clear);
        
        lbl_basket.setBounds (260, 20, 400, 25);
        f.setBounds (260, 75, 400, 600);
        btn_rent.setBounds(40, 350, 200, 25);
        btn_back.setBounds(40, 375, 200, 25);
        btn_clear.setBounds(40, 400, 200, 25);
        
        btn_rent.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {       
                help.rent();  
                pm.getPanelFromFactory(5);
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
