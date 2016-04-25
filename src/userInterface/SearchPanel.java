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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kamil
 */
public class SearchPanel extends Panel{
    private final JTextField txb_Title;
    private final JLabel lbl_searchItem, lbl_title, lbl_type, lbl_platform;
    private final JComboBox jcb_Type, jcb_platform;
    private final JButton btn_Search, btn_back;
    private PanelManager pm;
    private final Helper help = Helper.getInstance();
    public SearchPanel() {
        
        panel = new JPanel();
        
        //components of combo boxes
        String[] jcb_TypeItems = {"Movie", "Game"};  
        String[] jcb_PlatformTypes = {"PS3", "PS4", "Xbox One"};
        
        //construct components
        txb_Title = new JTextField (0);
        lbl_searchItem = new JLabel ("Search for Item");
        lbl_title = new JLabel ("Title: ");
        lbl_type = new JLabel ("Type: ");
        jcb_Type = new JComboBox (jcb_TypeItems);
        btn_Search = new JButton ("Search");
        btn_back = new JButton();
        jcb_platform = new JComboBox(jcb_PlatformTypes);
        lbl_platform = new JLabel("Platform: ");
        
        //adjust size and set layout
        panel.setPreferredSize (new Dimension (667, 366));
        panel.setLayout (null);

        //add components
        panel.add (txb_Title);
        panel.add (lbl_searchItem);
        panel.add (lbl_title);
        panel.add (lbl_type);
        panel.add (jcb_Type);
        panel.add (btn_Search);
        panel.add (btn_back);
        panel.add (jcb_platform);
        panel.add (lbl_platform);
        
        //set component bounds (only needed by Absolute Positioning)
        txb_Title.setBounds (245, 95, 100, 25);
        lbl_searchItem.setBounds (250, 45, 90, 25);
        lbl_title.setBounds (210, 95, 35, 25);
        lbl_type.setBounds (210, 125, 35, 25);
        jcb_Type.setBounds (245, 125, 100, 25);
        btn_Search.setBounds (245, 185, 100, 25);
        btn_back.setBounds (245, 215, 100, 25);
        jcb_platform.setBounds (245, 155, 100, 25);
        lbl_platform.setBounds (190, 155, 120, 25);
        
        jcb_platform.setVisible(false); //initialy set platform combo box and label to not visible
        lbl_platform.setVisible(false);
        
        btn_Search.addActionListener(new ActionListener() { //search for items
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        }); 
        
        btn_back.setText("Back");     //back to main menu
        panel.add(btn_back);   
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                pm.getPanelFromFactory(2);
            }
        }); 
        
        jcb_Type.addActionListener (new ActionListener () { //set action listener for the item type
          public void actionPerformed(ActionEvent e) {
          if(jcb_Type.getSelectedItem().toString().equals("Game")) //if game selected 
          {                                                        //set platform combo_box to visible  
            jcb_platform.setVisible(true);
            lbl_platform.setVisible(true);
          }
          else                                                     //else if movie selected  
          {                                                        //set platform combo_box to not visible
             jcb_platform.setVisible(false);  
             lbl_platform.setVisible(false);
          }
        }
        });
    }

  
    private void btnAddActionPerformed(ActionEvent evt)
    {
        String title, type;
        title = txb_Title.getText().trim(); //get title from textbox
        type =  jcb_Type.getSelectedItem().toString().trim(); //get type from combo box
        String c = jcb_platform.getSelectedItem().toString(); //selected console
        help.getProductByTitle(title, type, c);
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
