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
import inventory.Item;
import java.awt.Dimension;
import javax.swing.JOptionPane;


public class RentPanel extends Panel{
private PanelManager pm;
private final JPanel panel;
private final Helper help = Helper.getInstance();
    private JTextField txt_item;
    private JLabel lbl_item;
    private JLabel lbl_days;
    private JTextField txt_days;
    private JButton btn_add;
    private JButton btn_back;


public RentPanel() 
{
    panel = new JPanel();
    panel.setLayout(null);
    
        txt_item = new JTextField (5);
        lbl_item = new JLabel ("Item ID");
        lbl_days = new JLabel ("Days");
        txt_days = new JTextField (5);
        btn_add = new JButton ("Add");
        btn_back = new JButton ("Back");
        

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (601, 336));
        panel.setLayout (null);

        //add components
        panel.add (txt_item);
        panel.add (lbl_item);
        panel.add (lbl_days);
        panel.add (txt_days);
        panel.add (btn_add);
        panel.add (btn_back);

        //set component bounds (only needed by Absolute Positioning)
        txt_item.setBounds (120, 65, 100, 25);
        lbl_item.setBounds (5, 65, 100, 25);
        lbl_days.setBounds (5, 110, 100, 25);
        txt_days.setBounds (120, 105, 100, 25);
        btn_add.setBounds (120, 150, 100, 25);
        btn_back.setBounds (120, 185, 100, 25);
    
        btn_add.setText("Add to basket");
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Item i = help.getItemByID(txt_item.getText());
                if(help.getItemByID(txt_item.getText().trim()) != null){
                    if((i.isAdultRated()) && !(help.isCustomerAdult())){
                        JOptionPane.showMessageDialog(null, "Adult access is needed");
                    }
                    else{
                    help.addToBasket(i,  Integer.parseInt(txt_days.getText().trim()));
                    }
                }
            }
        }); 
        
        
        btn_back.setText("Back");
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
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
