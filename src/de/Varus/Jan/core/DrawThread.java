package de.Varus.Jan.core;

import javax.swing.JPanel;

import de.Varus.Jan.core.frame.Printer.IPrinter;

public class DrawThread extends Thread {
	private JPanel panel; 
	public DrawThread(IPrinter printer) {
		if(printer instanceof JPanel) {
			this.panel = (JPanel) printer; 
		} else {
			// TODO Add Exeption Handle 
			
		}
	}
	
	@Override
	public void run() {
		while(true) {
				
			panel.print(panel.getGraphics());
			
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
