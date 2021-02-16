package de.Varus.Jan.core;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.frame.Printer.IPrinter;

public class DrawThread extends Thread {
	private JPanel panel; 
	private JFrame frame; 
	public DrawThread(IPrinter printer, JFrame frame) {
		this.frame = frame; 
		if(printer instanceof JPanel) {
			this.panel = (JPanel) printer; 
		} else {
			// TODO Add Exeption Handle 
			
		}
	}
	
	@Override
	public void run() {
		while(true) {
			
			panel.paint(frame.getGraphics());
			System.out.println("DrawThread");
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void chancePrinter(IPrinter printer) {
		if(printer instanceof JPanel) {
			this.panel = (JPanel) printer; 
		} else {
			// TODO Add Exeption Handle 
		}
	}
}
