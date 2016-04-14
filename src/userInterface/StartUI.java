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
        /* Starts database connection */
        DatabaseInterface dbConn = new Database();
        /* Will process input taken from client GUI */
        Helper help = Helper.getInstance();
        help.setDbConn(dbConn);
        /* Panel factory to display panels on window */
        PanelFactory panelFac = new PanelFactory(help);
        /* Subject in observer pattern */
        PanelManager panelMgr = new PanelManager(panelFac);
        panelMgr.registerObserver(window);
    }
}
