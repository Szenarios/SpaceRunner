package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JFrame;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
/**
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public interface IPrinter {
	/**
	 * Registiert die gebrauchten Listener auf unser Frame
	 * @param frame Der {@link JFrame} auf dem die Listener Regestiert werden sollen. 
	 */
	void registerListeners(JFrame frame);
	/**
	 * Unregistiert die gebrauchten Listener auf unser Frame
	 * @param frame Der {@link JFrame} auf dem die Listener Unregestiert werden sollen. 
	 */
	void unregisterListeners(JFrame frame);
	/**
	 * Gibt alle Drawables zurück. 
	 * @return Eine Lister Aller {@link Drawable}s. 
	 */
	List<Drawable> getDrawable(); 
	/**
	 * Zeichnet alle {@link Drawable}s. 
	 * @param g {@link Graphics2D} auf dem diese {@link Drawable} gezeichnet werden sollen. 
	 */
	void drawAll(Graphics2D g); 
	/**
	 * Fügt alle übergeben {@linkplain Drawable}s zu einer einer Liste hinzu. 
	 * @param drawable Alle {@linkplain Drawable} die zu zeichnen sind. 
	 */
	void registerDrawable(Drawable... drawable); 
}
