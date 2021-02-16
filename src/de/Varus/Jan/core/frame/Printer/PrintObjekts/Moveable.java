package de.Varus.Jan.core.frame.Printer.PrintObjekts;

import java.awt.Point;

public interface Moveable {
	boolean isMoving(); 
	Point currentPosition(); 
	Point lastBreakPosition(); 
	Point startPosition(); 
	void move();
	
}
