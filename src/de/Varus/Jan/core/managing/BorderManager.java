package de.Varus.Jan.core.managing;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

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

}
