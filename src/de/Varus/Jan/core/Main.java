	package de.Varus.Jan.core;

import java.awt.Component;

import de.Varus.Jan.core.Discord.RPC.DiscordStatus;
import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.IPrinter;
import de.Varus.Jan.core.frame.Printer.MenuPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class Main {
	public  static MainFrame mainFrame; 
	private static IPrinter aktivPrinter;  
	private static DrawThread thread;
	
	public static DiscordStatus discordStatus; 
	public static void main(String[] args) {
		discordStatus = new DiscordStatus();
		mainFrame = new MainFrame(); 
		aktivPrinter = new MenuPrinter(); 
		aktivPrinter.registerListeners(mainFrame);
		mainFrame.add((Component) aktivPrinter); 
		
		

		thread = new DrawThread((Component) aktivPrinter, mainFrame); 
		thread.start();
	}
	
	public static void switchPrinter(IPrinter printer) { 
		aktivPrinter.unregisterListeners(mainFrame);
		mainFrame.remove((Component) aktivPrinter);
		
		
		aktivPrinter = printer; 
		aktivPrinter.registerListeners(mainFrame);
		mainFrame.add((Component) printer);
		thread.chancePrinter((Component) printer);
	}
	
	
}
