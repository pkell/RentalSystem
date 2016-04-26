
package userInterface;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
/**
 *
 * @author nrage
 */
public class StaffPanel extends Panel {
    private JPanel panel;
    private PanelManager pm;
    private Helper help = Helper.getInstance();
    private JTextField txt_del;
    private JLabel lbl_delUser;
    private JLabel lbl_grant;
    private JTextField txt_grant;
    private JButton btn_del;
    private JButton btn_grant;
    private JTextField txt_return;
    private JLabel lbl_return;
    private JButton btn_mark;

    public StaffPanel() {
        //construct components
        panel = new JPanel();
        txt_del = new JTextField (5);
        lbl_delUser = new JLabel ("Remove User");
        lbl_grant = new JLabel ("Grant Adult");
        txt_grant = new JTextField (5);
        btn_del = new JButton ("Remove");
        btn_grant = new JButton ("Grant");
        txt_return = new JTextField (5);
        lbl_return = new JLabel ("Mark Returned");
        btn_mark = new JButton ("Mark");
        //adjust size and set layout
        panel.setPreferredSize (new Dimension (667, 366));
        panel.setLayout (null);

        panel.setPreferredSize (new Dimension (601, 336));
        panel.setLayout (null);

        //add components
        panel.add (txt_del);
        panel.add (lbl_delUser);
        panel.add (lbl_grant);
        panel.add (txt_grant);
        panel.add (btn_del);
        panel.add (btn_grant);
        panel.add (txt_return);
        panel.add (lbl_return);
        panel.add (btn_mark);

        //set component bounds (only needed by Absolute Positioning)
        txt_del.setBounds (120, 35, 100, 25);
        lbl_delUser.setBounds (0, 30, 100, 25);
        lbl_grant.setBounds (0, 85, 100, 25);
        txt_grant.setBounds (120, 85, 100, 25);
        btn_del.setBounds (235, 35, 100, 25);
        btn_grant.setBounds (235, 85, 100, 25);
        txt_return.setBounds (120, 135, 100, 25);
        lbl_return.setBounds (0, 135, 100, 25);
        btn_mark.setBounds (235, 135, 100, 25);

        btn_del.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            help.deleteUser(txt_del.getText().trim());
            }
        });
  
        btn_grant.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            help.grantAdultAccess(txt_del.getText().trim());
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
