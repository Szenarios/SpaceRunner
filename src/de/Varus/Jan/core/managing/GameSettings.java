package de.Varus.Jan.core.managing;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class GameSettings {
	private Difficulty difficulty; 
	private int score; 
	private int lifes;
	
	public GameSettings(Difficulty difficulty, int score, int lifes) {
		this.difficulty = difficulty; 
		this.score = score; 
		this.lifes = lifes; 
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLifes() {
		return lifes;
	}
	public void setLifes(int lifes) {
		this.lifes = lifes;
	} 	
}
