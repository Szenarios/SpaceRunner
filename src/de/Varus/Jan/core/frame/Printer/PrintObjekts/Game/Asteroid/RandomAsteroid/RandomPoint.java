package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import java.awt.Point;
import java.awt.Toolkit;

/**
 * Gibt einen Random {@link Point} zurück. der zwischen null und der Maximalen Screen Breite ist. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
@SuppressWarnings("serial")
public class RandomPoint extends Point {
	/**
	 * Gibt einen Random {@link Point} wo der X wert zwischen der Maximalen ScreenGröße und 0 und der Y wert immer bei -255 liegt zurück.
	 */
	public RandomPoint() {
		super((int) (Math.random() * + Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 0), -225);
	}
}
