package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Moveable;

public class ShotPrint implements Drawable, Moveable{
	private int x; 
	private int y; 
	private int height; 
	private int width; 
	
	private boolean destroyed; 
	
	private Point startPosition; 
	public ShotPrint(Point startPosition) {
		this.startPosition = startPosition; 
		
		this.x = (int) startPosition.getX() + 100; 
		this.y = (int) startPosition.getY(); 
		
		this.height = 100; 
		this.width = 15; 
		
		this.destroyed = false; 
	}
	
	@Override
	public boolean isMoving() {
		return (y+height) > 0;
	}

	@Override
	public Point currentPosition() {
		return new Point(x,y);
	}

	@Override
	public Point lastBreakPosition() {
		return startPosition;
	}

	@Override
	public Point startPosition() {
		return startPosition;
	}

	@Override
	public void move() {
		this.y -= 25; 
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
		return this.width;
	}

	@Override
	public int height() {
		return this.height();
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public void draw(Graphics2D g) {
		 if(!isDestroyed()) {
			 g.setColor(Color.GREEN);
			 g.fillRect(x, y, width, height); 
			 move();
		 }
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
}
