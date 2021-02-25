package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.BorderManager;
import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;


public class BSettingsPrint implements Drawable, Clickable, Runnable {
	private final String PFAD = "Grafiks/Button.png"; 
	private int x; 
	private int y; 
	
	int height; 
	int width; 
	private Image image; 
	public BSettingsPrint() {
		try {
			image = ImageIO.read(new File(PFAD));
		} catch (IOException e) {
			image = null; 
			e.printStackTrace();
		} 
		this.width = 55; 
		this.height = 55;
		this.x = (int) (Main.mainFrame.getSize().getWidth() - width - 10); 
		this.y = (int) 10; 
		
		image = image.getScaledInstance(width, height, 0); 
	}
	
	@Override
	public void perfrom(Runnable run) {
		run.run(); 
	}

	@Override
	public boolean check(int x, int y) {
		return BorderManager.cordinateInside(this, x, y);
	}

	@Override
	public void checkAndRun(int x, int y) {
		if(check(x, y))
			perfrom(this);
	}
	
	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, null); 
	}

	@Override
	public void run() {
		System.err.println("Clicked!");
		// TODO Run after Clicking 
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
}