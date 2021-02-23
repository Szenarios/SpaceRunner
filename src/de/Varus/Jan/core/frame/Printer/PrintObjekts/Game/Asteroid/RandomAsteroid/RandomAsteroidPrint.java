package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;


public class RandomAsteroidPrint extends AsteroidPrint {
	private static Image rowImage; 
	public RandomAsteroidPrint(Difficulty difficulty) {
		super(getRandomImage(), new RandomVektor(difficulty), new RandomPoint(), getRandomSize());
	}
	private static Image getRandomImage() {
		if(rowImage == null) {
			try {
				rowImage = ImageIO.read(new File("Grafiks/Asteroid.png"));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		BufferedImage singleAsteroid = (BufferedImage) rowImage;

		int rdmY = (int) (Math.random() * 2 + 0); 
		int rdmX = (int) (Math.random() * 2 + 0); 
		
		return singleAsteroid.getSubimage(rdmX*225, rdmY*225, 225, 225); 
	}
	
	private static Dimension getRandomSize() {
		int size = (int) (Math.random() * 205 + 125); 
		return new Dimension(size, size); 
	}
	public String toString() { 
		return "x: " + this.x() + " y: "+ this.y() + "[" + this.height() + "|"+ this.width() +"]"; 
	}
}
