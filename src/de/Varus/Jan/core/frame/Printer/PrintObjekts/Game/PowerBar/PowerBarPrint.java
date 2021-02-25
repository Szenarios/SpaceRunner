package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBar;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class PowerBarPrint implements Drawable {
	/**
	 * X Koordinate 
	 */
	private int x; 
	/**
	 * Y Koordinate 
	 */
	private int y; 
	/**
	 * Breite in dem das Bild gezeichnet werden soll. 
	 */
	private int width; 
	/** 
	 * H�he in dem das Bild gezeichnet werden soll. 
	 */
	private int height; 
	
	/**
	 * Die Power der Bar. (0-100%)
	 */
	public double power; 
	
	/**
	 * Das {@link Image} was gezeichnet werden soll. 
	 */
	private Image image; 
	
	/**
	 * Die {@link GameSettings} zum Speichern des Power Wertes. 
	 */
	private GameSettings settings; 
	/**
	 * Zeichnet die Power bar je nach angebenden Power Wert in {@link GameSettings}
	 * @param settings Die {@link GameSettings} die den Powerwert verhaltet. 
	 */
	public PowerBarPrint(GameSettings settings) {
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
		
		this.settings = settings; 
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
			power += 1; 
			
		
		settings.setPower((int) this.power);
		
		// Zeichnet die Power bar je nach Power. 
		g.drawImage(image, x, y, (int) ((width/100) * power), height, null); 
	}
}
