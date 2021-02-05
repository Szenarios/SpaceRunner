package de.Varus.Jan.core;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.IPrinter;
import de.Varus.Jan.core.frame.Printer.MenuPrinter;

public class Main {
	private static JFrame mainFrame; 
	private static IPrinter aktivPrinter;  
	public static void main(String[] args) {
		
		aktivPrinter = new MenuPrinter(); 
		mainFrame = new MainFrame(); 
		mainFrame.add((JPanel)aktivPrinter); 
		
		
		DrawThread thread = new DrawThread(aktivPrinter); 
		thread.start();
	}
}
