package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import java.awt.Dimension;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;


public class RandomAsteroidPrint extends AsteroidPrint {
	/**
	 * Erzeugt ein {@link AsteroidPrint} mit Random Richtung Vektor, Random Größe und einem Random Texture
	 * @param difficulty
	 */
	public RandomAsteroidPrint(Difficulty difficulty) {
		super(getRandomImage(), new RandomVektor(5,0, difficulty.getMaxSpeed(), difficulty.getMinSpeed()), new RandomPoint(), getRandomSize());
	}

	/**
	 * Gibt eine Random Größe zurücl
	 * @return {@link Dimension} diese zwischen 205px(Maximal) und 125px(Minimal) liegt.   
	 */
	private static Dimension getRandomSize() {
		int size = (int) (Math.random() * 205 + 125); 
		return new Dimension(size, size); 
	}
	/**
	 * Gibt den Position sowie die Größe als String zurück.
	 * @return {@link String} mit der Größe und Position. 
	 */
	public String toString() { 
		return "x: " + this.x() + " y: "+ this.y() + "[" + this.height() + "|"+ this.width() +"]"; 
	}
}
