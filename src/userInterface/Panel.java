/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javax.swing.JPanel;

public abstract class Panel 
{
	protected PanelManager panelMgr;
	protected Helper help;
	protected JPanel panel;
	
	public Panel()
	{
		
	}
	
	public abstract JPanel sendToWindow();
	public void setPanelManager(PanelManager panelMgr)
	{
		this.panelMgr = panelMgr;
	}
	public void setProcessInput(Helper help)
	{
		this.help = help;
	}
}
