package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Moveable;

public class AsteroidPrint implements Drawable, Moveable {
	private Image image; 
	
	private int x;
	private int y; 
	
	private int height; 
	private int width;
	private boolean moving; 
	
	private Point startPos; 
	private Point lastPos; 

	private SimpleVektor vektor; 
	public AsteroidPrint(SimpleVektor vektor, Point start, Dimension size) {
		this.vektor = vektor; 
		try {
			image = ImageIO.read(new File(""));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.x = (int) start.getX(); 
		this.y = (int) start.getY(); 
		
		this.height = (int) size.getHeight(); 
		this.width = (int) size.getWidth(); 
	}
	@Override
	public boolean isMoving() {
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
		g.drawImage(image, x, y, width, height, null); 
	}
}
