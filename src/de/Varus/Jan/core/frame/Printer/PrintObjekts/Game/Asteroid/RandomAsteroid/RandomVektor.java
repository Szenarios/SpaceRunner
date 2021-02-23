package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.SimpleVektor;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class RandomVektor extends SimpleVektor {

	public RandomVektor(int maxX, int minX, int maxSpeed, int minSpeed) {
		super((int) (Math.random() * maxX + minX), (int) (Math.random() * maxSpeed + minSpeed));
	}

}
