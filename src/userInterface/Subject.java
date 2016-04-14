/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javax.swing.JPanel;
/**
 *
 * @author nrage
 */
public interface Subject {		
	
	void registerObserver(MainWindow window);
	void removeObserver();
	void notifyObserver();
	Panel getCurrentPanel();
}