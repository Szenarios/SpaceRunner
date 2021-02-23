package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Moveable;

public class AsteroidPrint implements Drawable, Moveable {
	private Image image; 
	private static Image rowImage; 
	
	private int x;
	private int y; 
	
	private int height; 
	private int width;
	
	private boolean moving = true; 
	
	private Point startPos; 
	private Point lastPos;
	
	private boolean destroyed; 
	private SmallAsteroidPrint[] smallAsteorieds; 

	public SimpleVektor vektor; 
	public AsteroidPrint(Image image, SimpleVektor vektor, Point start, Dimension size) {
		this.vektor = vektor; 
		this.image = image; 
		
		this.x = (int) start.getX(); 
		this.y = (int) start.getY(); 
		
		this.height = (int) size.getHeight(); 
		this.width = (int) size.getWidth(); 
	}
	@Override
	public boolean isMoving() {
		if (!isDestroyed())
			return y > Toolkit.getDefaultToolkit().getScreenSize().getHeight() ? false : true; 
		return moving;
	}

	@Override
	public Point currentPosition() {
		return new Point(x, y);
	}

	@Override
	public Point lastBreakPosition() {
		return lastPos;
	}

	@Override
	public Point startPosition() {
		return startPos;
	}

	@Override
	public void move() {
		this.x = x + vektor.getX(); 
		this.y = y + vektor.getY(); 
	}

	@Override
	public int x() {
		return this.x;
	}

	@Override
	public int y() {
		return this.y;
	}

	@Override
	public int width() {
		return width;
	}

	@Override
	public int height() {
		return height;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		if(isMoving())
			if(!isDestroyed()) {
				g.drawImage(image, x, y, width, height, null); 
			} else {
				if(smallAsteorieds == null) 
					generateSmallAsteroids();
				
				if(smallAsteorieds[0].currentPosition().distance(this.currentPosition()) > 575) 
					this.moving = false; 
				
				for (SmallAsteroidPrint smallAsteroidPrint : smallAsteorieds) {
					g.drawImage(smallAsteroidPrint.getImage(), smallAsteroidPrint.x(), smallAsteroidPrint.y(), smallAsteroidPrint.width(), smallAsteroidPrint.height(), null); 
					smallAsteroidPrint.move();
				}
				
			}
	}
	
	public void generateSmallAsteroids() {
		smallAsteorieds = new SmallAsteroidPrint[6];
		for (int i = 0; i < smallAsteorieds.length; i++) {
			smallAsteorieds[i] = new SmallAsteroidPrint(new Point(this.currentPosition().x + (this.width / 2), this.currentPosition().y + (this.height / 2))); 
			System.out.println(smallAsteorieds[i].vektor.toString());
		}
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	public void Destroy() {
		this.destroyed = true; 
	}
	
	public static Image getRandomImage() {
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
}
