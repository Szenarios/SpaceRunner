package de.Varus.Jan.core.frame.Printer.PrintObjekts;

import java.awt.Point;

import de.Varus.Jan.core.frame.Listener.PowerBar;

public interface Moveable {
	/**
	 * Gibt zur�ck ob sich das Objekt bewegt. 
	 * @return true wenn sich das Objekt bewegt. False wenn nicht. 
	 */
	boolean isMoving(); 
	/**
	 * Die Aktuelle {@link Point} wo sich das Objekt befindet. 
	 * @return Der {@link Point} wo sich das Objekt befindet. 
	 */
	Point currentPosition(); 
	/**
	 * Der Letzte {@link Point} wo das Objekt sich nicht bewegt hat.
	 * @return Der {@link Point} wo sich das Objekt als letzte nicht bewegt hat. 
	 */
	Point lastBreakPosition(); 
	/**
	 * Der Start{@link Point} wo das Objekt gestartet ist. 
	 * @return Der {@link Point} wo der das Objekt gestartet ist. 
	 */
	Point startPosition(); 
	/**
	 * Bewegt das Objekt. 
	 */
	void move();
	
}
