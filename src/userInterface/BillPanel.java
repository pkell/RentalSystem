/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Kamil
 */
public class BillPanel extends Panel {
    
    private final JLabel h;
    private PanelManager pm;
    private final JButton btn_back;
    private final Helper help = Helper.getInstance();
    public BillPanel(){
    

    panel = new JPanel(); 
       
        panel.setLayout (null);
        h = new JLabel(help.header(), SwingConstants.CENTER);
        btn_back = new JButton("Back");
        h.setVerticalAlignment(SwingConstants.TOP);
        panel.add(h);
        panel.add(btn_back);
        
        h.setBounds (260, 5, 400, 600);
        btn_back.setBounds(100, 265, 100, 25);
        
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
