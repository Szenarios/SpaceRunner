package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty;

public enum Difficulty {
	HARD(3), NORMAL(2), EASY(1); 
	int position; 
	Difficulty(int position) {
		this.position = position; 
	}
	public int getPosition() {
		return position;
	}
	
}
