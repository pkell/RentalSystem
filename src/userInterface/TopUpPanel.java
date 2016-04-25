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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kamil
 */
public class TopUpPanel extends Panel {
    
    private PanelManager pm;
    private final JLabel lbl_TopUp, lbl_balance, lbl_currentBalance;
    private JTextField txb_TopUpAmount;
    private final JButton btn_TopUp, btn_back;
    private Helper help = Helper.getInstance();
    
    public TopUpPanel()
    {
        panel = new JPanel();
        //construct components
        lbl_TopUp = new JLabel ("Enter Amount: ");
        txb_TopUpAmount = new JTextField (0);
        btn_TopUp = new JButton ("Top Up");
        btn_back = new JButton ("Back");
        lbl_balance = new JLabel(Double.toString(help.getBalance()));
        lbl_currentBalance = new JLabel("Current Balance: ");

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (667, 366));
        panel.setLayout (null);

        //add components
        panel.add (lbl_TopUp);
        panel.add (txb_TopUpAmount);
        panel.add (btn_TopUp);
        panel.add (btn_back);
        panel.add (lbl_balance);
        panel.add (lbl_currentBalance);
        //set component bounds (only needed by Absolute Positioning)
        lbl_TopUp.setBounds (200, 100, 85, 25);
        lbl_currentBalance.setBounds(185, 70, 100, 25);
        lbl_balance.setBounds (285, 70, 100, 25);
        txb_TopUpAmount.setBounds (285, 100, 100, 25);
        btn_TopUp.setBounds (285, 130, 100, 25);   
        btn_back.setBounds (285, 160, 100, 25);
        
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(2);
                }
                });
        
        btn_TopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help.topUp(Double.parseDouble(txb_TopUpAmount.getText())); 
                pm.getPanelFromFactory(6);
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