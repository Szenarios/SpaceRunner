
package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class LifeBarPrint implements Drawable {
	private int x; 
	private int y; 
	private int width; 
	private int height; 
	
	private Image image; 
	
	public LifeBarPrint() {
		try {
			image = ImageIO.read(new File("Grafiks/Leben.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		width = image.getWidth(null)*2; 
		height = image.getHeight(null); 
		
		y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - height - 20); 
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
		g.drawImage(image, x, y, width, height, null); 
	}

}
