package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import java.awt.Point;
import java.awt.Toolkit;

public class RandomPoint extends Point {
	public RandomPoint() {
		super((int) (Math.random() * + Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 0), -225);
	}
}
