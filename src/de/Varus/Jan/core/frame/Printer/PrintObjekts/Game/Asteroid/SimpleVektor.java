package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid;
/**
 * Ein einfacher Vektor. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class SimpleVektor {
	/*
	 * X Koordinate 
	 */
	private int x; 
	/**
	 * Y Koordinate 
	 */
	private int y; 
	/**
	 * Speichert zwei Punkte. Dabei werden diese als Vektor genutzt. 
	 * @param x Die X Koordinate 
	 * @param y Die Y Koordinate 
	 */
	public SimpleVektor(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	/**
	 * Gibt den X Wert zurück. 
	 * @return die X Koordinate. 
	 */
	public int getX() {
		return x;
	}
	/**
	 * Setzt die X Koordinate neu. 
	 * @param x Die neue X Koordinate 
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Gibt den Y Wert zurück. 
	 * @return die Y Koordinate. 
	 */
	public int getY() {
		return y;
	}
	/**
	 * Setzt die Y Koordinate neu. 
	 * @param y Die neue Y Koordinate 
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gibt in einem {@link String} die X und Y werte zurück. 
	 * @return Einen String mti X und Y Kordinate. 
	 */
	public String toString() {
		return "x: " + x + " y: "+ y; 
	}
}
