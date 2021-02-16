package de.Varus.Jan.Test;

import java.awt.Graphics2D;
import java.awt.Image;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class TestDrawable implements Drawable {
	private int x; 
	private int y; 
	private int width; 
	private int height; 
	public TestDrawable(int x, int y, int width, int height) {
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.height = height; 
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
		return this.height;
	}

	@Override
	public Image getImage() {return null;}

	@Override
	public void draw(Graphics2D g) {}

}
