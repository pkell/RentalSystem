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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import inventory.Item;
import java.awt.Dimension;
import javax.swing.JScrollPane;


public class RentalsPanel extends Panel{
private PanelManager pm;
private final JPanel panel;
private final Helper help = Helper.getInstance();
private JTextArea jRentals;
private JScrollPane scrollPane;
private JButton btn_back;


public RentalsPanel() 
{
    panel = new JPanel();
    panel.setLayout(null);
    btn_back = new JButton ("Back");
    jRentals = new JTextArea(help.displayRentals(), 5, 20);
    scrollPane = new JScrollPane(jRentals); 
    jRentals.setEditable(false);

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (601, 336));
        panel.setLayout (null);
        scrollPane.setBounds (40, 55, 100, 75);
        panel.add(scrollPane);
        panel.add(btn_back);
        btn_back.setBounds (20, 165, 100, 25);
        
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
