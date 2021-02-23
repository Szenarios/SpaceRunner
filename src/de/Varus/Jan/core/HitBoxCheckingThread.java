package de.Varus.Jan.core;

import java.util.List;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ShotPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.SpaceShip;
import de.Varus.Jan.core.managing.BorderManager;
import de.Varus.Jan.core.managing.GameSettings;

public class HitBoxCheckingThread extends Thread {
	private SpaceShip spaceShip; 
	private List<AsteroidPrint> asteroids; 
	private GameSettings settings; 
	
	private boolean gameOver = false; 
	public HitBoxCheckingThread(SpaceShip spaceShip, List<AsteroidPrint> asteroids, GameSettings settings) {
		super("HitboxCheck Thread"); 
		
		this.spaceShip = spaceShip; 
		this.asteroids = asteroids; 
		this.settings = settings; 
		
		this.start();
	}
	public void updateAsteroids(List<AsteroidPrint> asteroids) {
		this.asteroids = asteroids; 
	}
	
	@Override
	public void run() {
		while(settings.getLifes() != 0) {
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
			
			for (int d = 0; d <  asteroids.size(); d++) {
				AsteroidPrint asteroid = asteroids.get(d); 
				
				if(settings.getLifes() <= 0)
					this.gameOver = true; 
				
				
				if(!asteroid.isDestroyed())
					if(BorderManager.SquareOverlapSquare(asteroid, spaceShip)) {
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
	
	public boolean isGameOver() {
		return this.gameOver; 
	}
}
