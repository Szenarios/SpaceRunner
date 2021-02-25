package de.Varus.Jan.core;

import java.awt.Rectangle;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class BorderManager {
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
	
	public static boolean SquareOverlapSquare (Drawable d, Drawable d2) {
		Rectangle rectD = new Rectangle(d.x(), d.y(), d.width(), d.height());
		Rectangle rectD2 = new Rectangle(d2.x(), d2.y(), d2.width(), d2.height());
		
		return rectD.intersects(rectD2); 
	}
	
}
