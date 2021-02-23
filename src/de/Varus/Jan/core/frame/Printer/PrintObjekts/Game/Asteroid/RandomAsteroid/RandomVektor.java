package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.SimpleVektor;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class RandomVektor extends SimpleVektor {

	public RandomVektor(Difficulty difficulty) {
		super((int) (Math.random() * 5 + 0), (int) (Math.random() * difficulty.getMaxSpeed() + difficulty.getMinSpeed()));
	}

}
