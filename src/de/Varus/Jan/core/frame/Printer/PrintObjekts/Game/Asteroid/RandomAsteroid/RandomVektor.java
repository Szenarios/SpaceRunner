package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.SimpleVektor;

/**
 * Gibt einen Random Richtungs Vektor wieder der zwischen bestimmten werten liegt. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class RandomVektor extends SimpleVektor {
	
	/**
	 * Gibt einen Random {@link SimpleVektor} zurück der zwischen den Angegebenden Maximal und Minimal werten liegt.
	 * @param maxX Der Maximale X Wert. 
	 * @param minX Der Minimale X Wert. 
	 * @param maxSpeed Der Maximale Y Wert. (Hier die Maximale Geschwindigkeit da der Vektor sich nach Unten bewegt.)
	 * @param minSpeed Der Minimale Y Wert. (Hier die Minimale Geschwindigkeit da der Vektor sich nach Unten bewegt.)
	 */
	public RandomVektor(int maxX, int minX, int maxSpeed, int minSpeed) {
		super((int) (Math.random() * maxX + minX), (int) (Math.random() * maxSpeed + minSpeed));
	}

}
