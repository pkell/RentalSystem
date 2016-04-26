/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class AddItemPanel extends Panel {
    private Helper help = Helper.getInstance();
    private PanelManager pm;
    private JPanel panel;
    private JTextField txt_id;
    private JTextField txt_name;
    private JLabel lbl_id;
    private JLabel lbl_name;
    private JCheckBox isAdult;
    private JButton btn_add;
    private JComboBox jType;
    private JButton btn_back;
    
    public AddItemPanel(){
        String[] jTypeItems = {"Movie", "Game"};

        panel = new JPanel();
        txt_id = new JTextField (5);
        txt_name = new JTextField (5);
        lbl_id = new JLabel ("ItemID");
        lbl_name = new JLabel ("Name");
        isAdult = new JCheckBox ("Adults Only");
        btn_add = new JButton ("Add Item");
        jType = new JComboBox (jTypeItems);
        btn_back = new JButton ("Back");

        //adjust size and set layout
        panel.setPreferredSize (new Dimension (601, 336));
        panel.setLayout (null);

        //add components
        panel.add (txt_id);
        panel.add (txt_name);
        panel.add (lbl_id);
        panel.add (lbl_name);
        panel.add (isAdult);
        panel.add (btn_add);
        panel.add (jType);
        panel.add (btn_back);

        //set component bounds (only needed by Absolute Positioning)
        txt_id.setBounds (135, 40, 100, 25);
        txt_name.setBounds (135, 70, 100, 25);
        lbl_id.setBounds (10, 40, 100, 25);
        lbl_name.setBounds (10, 70, 100, 25);
        isAdult.setBounds (130, 110, 120, 20);
        btn_add.setBounds (130, 165, 100, 25);
        jType.setBounds (135, 135, 100, 25);
        btn_back.setBounds (0, 195, 100, 25);
        
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jType.getSelectedItem() == "Movie") {
                    help.addMovie(txt_id.getText().trim(), txt_name.getText().trim(),isAdult.isSelected());
                }
                else if(jType.getSelectedItem() == "Game"){
                    help.addGame(txt_id.getText().trim(), txt_name.getText().trim(),isAdult.isSelected());
                }
            }
        });
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pm.getPanelFromFactory(8);
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
