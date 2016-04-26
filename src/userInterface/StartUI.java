/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;
import database.*;
/**
 *
 * @author nrage
 */
public class StartUI {
    
    public static void main(String [] args){
        MainWindow window = new MainWindow();
        DatabaseInterface dbConn = new Database();
        DatabaseAccess dba = DatabaseAccess.getInstance();
        dba.setDbconn(dbConn);
        Helper help = Helper.getInstance();
        help.setDbAccess(dba);
        PanelFactory panelFac = new PanelFactory(help);
        PanelManager panelMgr = new PanelManager(panelFac);
        panelMgr.registerObserver(window);
    }
}
