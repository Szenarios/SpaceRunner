	package de.Varus.Jan.core;

import java.awt.Component;

import javax.swing.JFrame;

import de.Varus.Jan.core.Discord.RPC.DiscordStatus;
import de.Varus.Jan.core.Musik.MusikPlayer;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.IPrinter;
import de.Varus.Jan.core.frame.Printer.MenuPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;
/**
 * Die Main Klasse die alles vereint. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class Main {
	/**
	 * Das {@link MainFrame} als {@link JFrame}. 
	 */
	public  static MainFrame mainFrame; 
	/**
	 * Der Aktuelle {@link IPrinter} der auf das {@link MainFrame} gezeichnet wird.
	 */
	private static IPrinter aktivPrinter;  
	/**
	 * Der {@link DrawThread} der den {@link IPrinter} immer wieder neu auf das {@link MainFrame} zeichnet. 
	 */
	private static DrawThread thread;
	
	/**
	 * Der {@link DiscordStatus} manager der den Status Aktuelle hält. 
	 */
	public static DiscordStatus discordStatus; 
	
	private static GameSettings settings; 
	
	/**
	 * Der {@link MusikPlayer} der unsere Musik Managet. 
	 */
	public static MusikPlayer musikPlayer; 
	/**
	 * Die Main Methode
	 * @param args Args die Übergeben werden. 
	 */
	public static void main(String[] args) {
		settings = new GameSettings(Difficulty.NORMAL); 
		
		musikPlayer = new MusikPlayer(); 
		discordStatus = new DiscordStatus();

		mainFrame = new MainFrame(); 
		aktivPrinter = new MenuPrinter(settings); 
		aktivPrinter.registerListeners(mainFrame);
		
		mainFrame.add((Component) aktivPrinter); 

		thread = new DrawThread((Component) aktivPrinter, mainFrame); 
		thread.start();
	}
	
	/**
	 * Ändert den Aktuellen {@link IPrinter} im {@link DrawThread}. 
	 * @param printer Der Neue {@link IPrinter}
	 */
	public static void switchPrinter(IPrinter printer) { 
		aktivPrinter.unregisterListeners(mainFrame);
		mainFrame.remove((Component) aktivPrinter);
		
		
		aktivPrinter = printer; 
		aktivPrinter.registerListeners(mainFrame);
		mainFrame.add((Component) printer);
		thread.chancePrinter((Component) printer);
	}
	
	
}
