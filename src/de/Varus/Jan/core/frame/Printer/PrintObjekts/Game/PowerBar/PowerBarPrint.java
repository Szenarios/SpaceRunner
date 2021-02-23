package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBar;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class PowerBarPrint implements Drawable{
	private int x; 
	private int y; 
	private int width; 
	private int height; 
	
	public double power; 
	
	private Image image; 
	
	public PowerBarPrint() {
		try {
			image = ImageIO.read(new File("Grafiks/PowerAnzeige.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		power = 100; 
		
		width = image.getWidth(null)*2; 
		height = image.getHeight(null); 
		
		y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - (height*2) - 35); 
		x = 35; 
		
	}
	@Override
	public int x() {
		return x;
	}

	@Override
	public int y() {
		return y;
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
		if(power < 100) 
			power += 0.555; 
			
		
		g.drawImage(image, x, y, (int) ((width/100) * power), height, null); 
	}
}
