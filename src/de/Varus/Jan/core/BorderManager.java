package de.Varus.Jan.core;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Collideable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
/**
 * Gibt an ob sich bestimmte Koordinaten oder Formen in bestimmen Koordinaten oder Formen befinden. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class BorderManager {
	/**
	 * Gibt an ob eine bestimmte Koordinate in einem Rechteck ist oder nicht. 
	 * @param d Das Rechteck. 
	 * @param x Die X Koordinate die überprüft werden soll. 
	 * @param y Die Y Koordinate die Überprüft werden soll
	 * @return True wenn die Koordinate in dem Rechteck liegt. False wenn nicht. 
	 */
	public static boolean cordinateInside(Drawable d, int x, int y)  {
		
		for (int i = d.x(); i <= (d.x() + d.width()); i++) {
			for (int j = d.y(); j <= (d.y() + d.height()); j++) {
				if(i == x && y == j) {
					return true; 
				}
			}
		}
		return false; 
	}
	
	/**
	 * Gibt zrück ob sich zwei Rechtecke schneiden oder übereinstimen.
	 * @param d Das erste Rechteck als {@link Collideable}
	 * @param d2 Das zweite Rechteck als {@link Collideable}
	 * @return True wenn sie sich überschneidne oder übereinander liegen. False wenn sie sich nicht berühren.
	 */
	public static boolean SquareOverlapSquare (Collideable d, Collideable d2) {
		return d.getHitbox().intersects(d2.getHitbox());
	}
	
}
