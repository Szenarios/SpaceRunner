package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid;

public class SimpleVektor {
	private int x; 
	private int y; 
	public SimpleVektor(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "x: " + x + " y: "+ y; 
	}
}
