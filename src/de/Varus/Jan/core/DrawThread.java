package de.Varus.Jan.core;

import java.awt.Component;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import de.Varus.Jan.core.frame.Printer.IPrinter;

public class DrawThread extends Thread {
	private Component component; 
	private JFrame frame; 
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
//			System.out.println("DrawThread");
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void chancePrinter(Component component) {
			this.component = component; 
	}
}
