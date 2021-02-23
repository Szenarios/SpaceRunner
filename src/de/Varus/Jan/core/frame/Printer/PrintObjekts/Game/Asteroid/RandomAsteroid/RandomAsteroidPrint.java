package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import java.awt.Dimension;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;


public class RandomAsteroidPrint extends AsteroidPrint {
	
	public RandomAsteroidPrint(Difficulty difficulty) {
		super(getRandomImage(), new RandomVektor(5,0, difficulty.getMaxSpeed(), difficulty.getMinSpeed()), new RandomPoint(), getRandomSize());
	}

	
	private static Dimension getRandomSize() {
		int size = (int) (Math.random() * 205 + 125); 
		return new Dimension(size, size); 
	}
	public String toString() { 
		return "x: " + this.x() + " y: "+ this.y() + "[" + this.height() + "|"+ this.width() +"]"; 
	}
}
