package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid;

import java.awt.Dimension;
import java.awt.Point;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid.RandomAsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid.RandomVektor;
/**
 * Ein Art von {@link RandomAsteroidPrint} nur in einem kleineren Format und ohne Hitboxen. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class SmallAsteroidPrint extends AsteroidPrint {
	/**
	 * Generiert einen kleinen Asteroiden. Ähnlich wie {@link RandomAsteroidPrint} nur mit anderen {@link SimpleVektor} als Richtungs Vektor. 
	 * @see RandomAsteroidPrint
	 * @see AsteroidPrint
	 * @see SimpleVektor
	 * @param point start Punkt des Asteroiden. 
	 */
	public SmallAsteroidPrint(Point point) {
		super(getRandomImage(), new RandomVektor(5, -5, 8, -5), point, new Dimension(75,75));
	}

}
