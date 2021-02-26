package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import java.awt.Dimension;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

/**
 * Ist ein {@link AsteroidPrint} nur mit Random Richtiguns Vektor sowie Koordinate abh�ngig von dem Schwierigkeitsgrad. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class RandomAsteroidPrint extends AsteroidPrint {
	/**
	 * Erzeugt ein {@link AsteroidPrint} mit Random Richtung Vektor, Random Gr��e und einem Random Texture
	 * @param difficulty Der Aktuelle {@link Difficulty}
	 */
	public RandomAsteroidPrint(Difficulty difficulty) {
		super(getRandomImage(), new RandomVektor(5,0, difficulty.getMaxSpeed(), difficulty.getMinSpeed()), new RandomPoint(), getRandomSize());
	}

	/**
	 * Gibt eine Random Gr��e zur�cl
	 * @return {@link Dimension} diese zwischen 205px(Maximal) und 125px(Minimal) liegt.   
	 */
	private static Dimension getRandomSize() {
		int size = (int) (Math.random() * 205 + 125); 
		return new Dimension(size, size); 
	}
	/**
	 * Gibt den Position sowie die Gr��e als String zur�ck.
	 * @return {@link String} mit der Gr��e und Position. 
	 */
	public String toString() { 
		return "x: " + this.x() + " y: "+ this.y() + "[" + this.height() + "|"+ this.width() +"]"; 
	}
}
