/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author nrage
 */
public class LoginPanel extends Panel{
    private Helper help = Helper.getInstance();
    private PanelManager pm;
    private JPanel panel;

    public LoginPanel() {
       setUpPanel();
    }
    
    public void setUpPanel(){
        final JButton jLogin = new JButton ("Submit");
        final JTextField jUser = new JTextField (5);
        final JLabel jUserLabel = new JLabel ("Username:");
        final JLabel jPassLabel = new JLabel ("Password:");
                final String[] jUserTypeItems = {"Customer", "Staff", "Manager"};
        final JComboBox jUserType = new JComboBox (jUserTypeItems);
        final JPasswordField jPassword = new JPasswordField (5);

        //construct components
        this.panel = new JPanel();

        //adjust size and set layout
        this.panel.setPreferredSize (new Dimension (601, 336));
        this.panel.setLayout (null);

        //add components
        this.panel.add (jLogin);
        this.panel.add (jUser);
        this.panel.add (jUserLabel);
        this.panel.add (jPassLabel);
        this.panel.add (jUserType);
        this.panel.add (jPassword);

        //set component bounds (only needed by Absolute Positioning)
        jLogin.setBounds (10, 170, 100, 20);
        jUser.setBounds (115, 65, 100, 25);
        jUserLabel.setBounds (10, 60, 100, 25);
        jPassLabel.setBounds (10, 115, 100, 25);
        jUserType.setBounds (150, 165, 100, 25);
        jPassword.setBounds (115, 115, 100, 25);
        
        jLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (jUserType.getSelectedItem() == "Customer") {
                    System.out.println("aa");
                    if (help.canCustomerLogin(jUser.getText().trim(), jPassword.getText().trim())) {
                        pm.getPanelFromFactory(2);
                    }
                } else if (jUserType.getSelectedItem() == "Staff") {
                    if (help.canStaffLogin(jUser.getText().trim(), jPassword.getText().trim())) {
                    }
                } else if (jUserType.getSelectedItem() == "Manager") {
                    if (help.canManagerLogin(jUser.getText().trim(), jPassword.getText().trim())) {
                    }
                }
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
