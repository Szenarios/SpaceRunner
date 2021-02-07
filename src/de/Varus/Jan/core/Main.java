package de.Varus.Jan.core;

import javax.swing.JPanel;

import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.IPrinter;
import de.Varus.Jan.core.frame.Printer.MenuPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class Main {
	public  static MainFrame mainFrame; 
	private static IPrinter aktivPrinter;  
	
	public static Difficulty difficulty = Difficulty.NORMAL; 
	public static void main(String[] args) {
		mainFrame = new MainFrame(); 
		
		aktivPrinter = new MenuPrinter(); 
		mainFrame.add((JPanel)aktivPrinter); 
		aktivPrinter.registerListeners(mainFrame);
		

		DrawThread thread = new DrawThread(aktivPrinter, mainFrame); 
		thread.start();
	}
}
