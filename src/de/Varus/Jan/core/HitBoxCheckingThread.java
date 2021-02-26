package de.Varus.Jan.core;

import java.util.ArrayList;
import java.util.List;

import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Listener.SpaceShip;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ShotPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.SpaceShipPrint;

public class HitBoxCheckingThread extends Thread {
	/**
	 * Das {@link SpaceShip}
	 */
	private SpaceShip spaceShip; 
	/**
	 * Die {@link AsteroidPrint}s in einer {@link ArrayList}
	 */
	private List<AsteroidPrint> asteroids; 
	/**
	 * Die Aktuellen Gamesettings
	 */
	private GameSettings settings; 
	
	/**
	 * Ob das Spiel Game Over ist (Wenn Game Over = true)
	 */
	private boolean gameOver = false; 
	/**
	 * Erstellt einen Thread der die Hitboxen der Angegeben Objekt übersprüft ob diese sich schneiden. 
	 * @param spaceShip Ein {@link SpaceShipPrint}. 
	 * @param asteroids Eine {@link ArrayList} an {@link AsteroidPrint}s. 
	 * @param settings Die Aktuellen {@link GameSettings} der Obejkte 
	 */
	public HitBoxCheckingThread(SpaceShip spaceShip, List<AsteroidPrint> asteroids, GameSettings settings) {
		super("HitboxCheck Thread"); 
		
		this.spaceShip = spaceShip; 
		this.asteroids = asteroids; 
		this.settings = settings; 
		
		this.start();
	}
	/**
	 * Aktuallisiert die {@link AsteroidPrint} {@link ArrayList}. 
	 * @param asteroids Die Neuen Asteorieden. (Liste wird komplett überschrieben)
	 */
	public void updateAsteroids(List<AsteroidPrint> asteroids) {
		this.asteroids = asteroids; 
	}
	
	@Override
	public void run() {
		while(settings.getLifes() != 0) { // Läuft solange der Spieler Leben hat. 
			// Überprüft ob das einer der Schüsse des Raumschiffs einen Asteoriden Trifft. 
			for (int i = 0; i < spaceShip.getShots().size(); i++) {
				ShotPrint shot = spaceShip.getShots().get(i); 
				for (int d = 0; d <  asteroids.size(); d++) {
					AsteroidPrint asteroid = asteroids.get(d); 
					if(BorderManager.SquareOverlapSquare(asteroid, shot)) {
						asteroid.Destroy();
						shot.setDestroyed(true);
						settings.setScore(settings.getScore()+5);
						System.err.println("treffer!");
					}
					
				}
			}
			
			// Checkt die Asteoriden Hitboxen mit dem Spaceship
			for (int d = 0; d <  asteroids.size(); d++) {
				AsteroidPrint asteroid = asteroids.get(d); 
				
				if(settings.getLifes() <= 0)
					this.gameOver = true; 
				
				
				if(!asteroid.isDestroyed())
					if(BorderManager.SquareOverlapSquare(spaceShip, asteroid)) {
						settings.setLifes(settings.getLifes() - settings.getDifficulty().getDamage());
						asteroid.Destroy();
						System.out.println(settings.getDifficulty().name());
					}
				
			}
				
			
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
	
	/**
	 * Gibt zurück ob das Aktuelle Spiel Game Over ist oder nicht. 
	 * @return true wenn es Game Over ist.
	 */
	public boolean isGameOver() {
		return this.gameOver; 
	}
}
