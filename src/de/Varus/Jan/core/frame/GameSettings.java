package de.Varus.Jan.core.frame;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class GameSettings {
	/**
	 * Der Aktuelle Difficulty des Games. 
	 */
	private Difficulty difficulty; 
	/**
	 * Der Aktuelle Score des Games. 
	 */
	private int score; 
	/**
	 * Die Aktuellen leben des Games. 
	 */
	private int lifes;
	
	/**
	 * Die Momentane Power des Raumschiffes. 
	 */
	private int power; 
	
	/**
	 * Ob die Story schon einmal angeschaut wurde oder nicht. 
	 */
	private boolean storyShown; 
	
	/**
	 * Beinhaltet alle Aktuellen Informationen über das Laufende Spiel. 
	 * @param difficulty Der Difficulty in dem das Spiel stattfindet. 
	 */
	public GameSettings(Difficulty difficulty) {
		this.difficulty = difficulty; 
		this.score = 0; 
		this.lifes = 100;
		this.power = 100; 
		this.storyShown = false; 
	}
	/**
	 * Gibt den Aktuellen {@link Difficulty} zurück. 
	 * @return Der Aktuelle {@link Difficulty}. 
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}
	/**
	 * Setzt den Aktuellen {@link Difficulty}. 
	 * @param difficulty Der neue Aktuelle {@link Difficulty}. 
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	/**
	 * Gibt den Aktuellen Score an. 
	 * @return Deb Aktuellen Score als {@link Integer}
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Setzt den Aktuellen Score. 
	 * @param score Der neue Aktuelle Score als {@link Integer}
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * Gibt die Aktuellen Leben als {@link Integer}
	 * @return Die neuen Aktuellen Leben als {@link Integer}
	 */
	public int getLifes() {
		return lifes;
	}
	/**
	 * Setztz die neuen Aktuellen Leben 
	 * @param lifes Die neuen Aktuellen Leben als {@link Integer}. 
	 */
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	/**
	 * Gibt die Aktuelle Power als {@link Integer} wieder.
	 * @return Die Aktuelle Power als {@link Integer}
	 */
	public int getPower() {
		return power;
	}
	/**
	 * Setzt die neue Aktuelle Poewr. 
	 * @param power Die neue Aktuelle Power als {@link Integer}
	 */
	public void setPower(int power) {
		this.power = power;
	}
	/**
	 * Gibt an ob die Story schon angezeigt wurde. 
	 * @return Ob die Story angeschaut wurde true wenn ja 
	 */
	public boolean isStoryShown() {
		return storyShown;
	}
	/**
	 * Setzt ob die Story schon angeschaut wurde oder nicht
	 * @param storyShown Der neue Wert ob die Stroy angeschaut wurde oder nicht. 
	 */
	public void setStoryShown(boolean storyShown) {
		this.storyShown = storyShown;
	} 	
	
	/**
	 * Setze die Werte auf die Normalwerte zurück
	 */
	public void reset() {
		this.difficulty = Difficulty.NORMAL; 
		this.score = 0; 
		this.lifes = 100;
		this.power = 100;
	}
	
}
