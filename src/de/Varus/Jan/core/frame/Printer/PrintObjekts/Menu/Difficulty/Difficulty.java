package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty;
/**
 * Gibt den Difficulty an und enthält alle grentwerte für diesen. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public enum Difficulty {
	HARD(3, 35, 13, 10, 15), NORMAL(2, 30, 8, 8, 10), EASY(1, 20, 8, 7, 7); 
	private int position; 
	
	private int maxSpeed; 
	private int minSpeed; 
	
	private int minAsteroiden; 
	
	private int damage; 
	
	Difficulty(int position, int maxSpeed, int minSpeed, int minAsteroiden, int damage) {
		this.position = position; 
		this.maxSpeed = maxSpeed; 
		this.minSpeed = minSpeed; 
		this.minAsteroiden = minAsteroiden; 
		this.damage = damage; 
	}
	
	
	public int getDamage() {
		return damage;
	}

	public int getPosition() {
		return position;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getMinSpeed() {
		return minSpeed;
	}

	public int getMinAsteroiden() {
		return minAsteroiden;
	}
	
	
}
