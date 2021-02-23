package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty;

public enum Difficulty {
	HARD(3, 35, 13, 17), NORMAL(2, 30, 8, 15), EASY(1, 20, 8, 10); 
	int position; 
	Difficulty(int position, int maxSpeed, int minSpeed, int minAsteroiden) {
		this.position = position; 
		this.maxSpeed = maxSpeed; 
		this.minSpeed = minSpeed; 
		this.minAsteroiden = minAsteroiden; 
	}
	private int maxSpeed; 
	private int minSpeed; 
	
	private int minAsteroiden; 
	
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
