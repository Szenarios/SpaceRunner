package de.Varus.Jan.core.frame.Printer.PrintObjekts;

import java.awt.Graphics2D;
import java.awt.Image;
/**
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public interface Drawable {
	/**
	 * Gibt die X Koordinate zurück. 
	 * @return Die X Koordinate als {@link Integer}. 
	 */
	int x(); 
	/**
	 * Gibt die Y Koordinate zurück. 
	 * @return Die Y Koordinate als {@link Integer}. 
	 */
	int y(); 
	/**
	 * Gibt die Breite zurück. 
	 * @return Die Breite als {@link Integer}. 
	 */
	int width(); 
	/**
	 * Gibt die Höhe zurück. 
	 * @return Die Höhe als {@link Integer}. 
	 */
	int height(); 
	/**
	 * Gibt das zuzeichnende {@link Image} zurück. 
	 * @return Das {@link Image} was gezeichnet werden soll. 
	 */
	Image getImage();
	/**
	 * Zeichnet das {@link Image} auf das angegeben {@link Graphics2D} Objekt. 
	 * @param g {@link Graphics2D} worauf das {@link Image} gezeichnet werden soll.
	 */
	void draw(Graphics2D g);
}
