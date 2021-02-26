package de.Varus.Jan.core;

import java.awt.Component;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.IPrinter;
/**
 * Updatet den {@link MainFrame} und das {@link Component} auf diesem. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class DrawThread extends Thread {
	/**
	 * Das {@link Component} was repaintet wird. 
	 */
	private Component component; 
	/**
	 * Der {@link JFrame} auf dem alles Stattfindet, 
	 */
	private JFrame frame; 
	/**
	 * Erzeugt einen Thread der den {@link MainFrame} Aktuallisiert. 
	 * @param component Das {@link Component} was neu gezeichnet wird. 
	 * @param frame Der {@link JFrame} auf dem es neu gezeichnet wird. 
	 */
	public DrawThread(Component component, JFrame frame) {
		this.frame = frame; 
		this.component = component; 
	}
	
	@Override
	public void run() {
		while(true) {
			if(component instanceof IPrinter)
				((IPrinter) component).drawAll((Graphics2D) frame.getGraphics());
			
			component.repaint();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Ändert das {@link Component} um die Scenerie zu ändern, hier ein {@link JPanel} 
	 * @param component Das neue {@link Component}.
	 */
	public void chancePrinter(Component component) {
			this.component = component; 
	}
}
