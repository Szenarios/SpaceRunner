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
	
	public static boolean SquareOverlapSquare (Drawable d, Drawable d2) {
		if(cordinateInside(d, d2.x(), d2.y())) {
			return true; 
		} else 
		if(cordinateInside(d, d2.x() + d2.width(), d2.y())) { 
			return true; 
		} else 
		if(cordinateInside(d, d2.x(), (d2.y() < 0 ? d2.y() + d2.height() : d2.y() - d2.height()))) { 
			return true; 
		} else 
		if(cordinateInside(d, d2.x() + d2.width(), (d2.y() < 0 ? d2.y() + d2.height() : d2.y() - d2.height()))) { 
			return true; 	
		}	
			
		return false;
	}
	
}
