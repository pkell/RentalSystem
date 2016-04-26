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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ManagerPanel extends Panel {
    
 private Helper help = Helper.getInstance();
    private PanelManager pm;
    private JPanel panel;

    public ManagerPanel() {
       setUpPanel();
    }
    
    public void setUpPanel(){
        final JButton jAdd = new JButton ("Add Item");
        final JButton jRemove = new JButton ("Remove Item");
        final JTextField jUser = new JTextField (5);
        final JLabel jProduct = new JLabel ("Enter Item Code:");
        final JLabel lbl_del = new JLabel ("Delete Staff");
        final JTextField txt_del = new JTextField (5);
        final JButton btn_del = new JButton ("Delete");
        

        this.panel = new JPanel();

        //adjust size and set layout
        this.panel.setPreferredSize (new Dimension (601, 336));
        this.panel.setLayout (null);

        //add components
        this.panel.add (jAdd);
        this.panel.add (jUser);
        this.panel.add (jProduct);
        this.panel.add (jRemove);
        this.panel.add (lbl_del);
        this.panel.add (txt_del);
        this.panel.add (btn_del);

        jAdd.setBounds (10, 170, 150, 20);
        jUser.setBounds (155, 65, 100, 25);
        jProduct.setBounds (10, 60, 150, 25);
        jRemove.setBounds(265,65,150,20);
        lbl_del.setBounds (15, 90, 100, 25);
        txt_del.setBounds (120, 90, 100, 25);
        btn_del.setBounds (245, 90, 100, 25);
        
        jRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help.removeItem(jUser.getText());

            }
        });
        
        jAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               pm.getPanelFromFactory(9);

            }
        }); 
        btn_del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               help.deleteStaff(txt_del.getText().trim());
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
