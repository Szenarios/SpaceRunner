package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid;

import java.awt.Dimension;
import java.awt.Point;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid.RandomVektor;

public class SmallAsteroidPrint extends AsteroidPrint {

	public SmallAsteroidPrint(Point point) {
		super(getRandomImage(), new RandomVektor(5, -5, 8, -5), point, new Dimension(75,75));
	}

}
