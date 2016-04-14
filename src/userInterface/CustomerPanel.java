/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
/**
 *
 * @author nrage
 */
public class CustomerPanel extends Panel {
    private JLabel jtest;
    private JPanel panel;
    private PanelManager pm;

    public CustomerPanel() {
        //construct components
        panel = new JPanel();
        jtest = new JLabel ("newLabel");

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (601, 336));
        panel.setLayout (null);

        //add components
        panel.add (jtest);

        //set component bounds (only needed by Absolute Positioning)
        jtest.setBounds (45, 105, 100, 25);
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
