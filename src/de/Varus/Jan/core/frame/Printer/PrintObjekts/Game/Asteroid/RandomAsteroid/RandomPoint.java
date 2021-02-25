package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import java.awt.Point;
import java.awt.Toolkit;

public class RandomPoint extends Point {
	/**
	 * Gibt einen Random {@link Point} wo der X wert zwischen der Maximalen ScreenGröße und 0 und der Y wert immer bei -255 liegt zurück.
	 */
	public RandomPoint() {
		super((int) (Math.random() * + Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 0), -225);
	}
}
