package de.Varus.Jan.core.frame;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class GameSettings {
	private Difficulty difficulty; 
	private int score; 
	private int lifes;
	
	private int power; 
	
	public GameSettings(Difficulty difficulty) {
		this.difficulty = difficulty; 
		this.score = 0; 
		this.lifes = 100;
		this.power = 100; 
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
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	} 	
}
