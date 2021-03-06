
package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
/**
 * Zeichnet eine LifeBar anhand der Aktuellen {@link GameSettings}.
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class LifeBarPrint implements Drawable {
	/**
	 * Die X Koordinate
	 */
	private int x; 
	/**
	 * Die Y Koordinate 
	 */
	private int y;
	/**
	 * Die Breite in der das Bild gezeichnet wird. 
	 */
	private int width; 
	/** 
	 * Die H�he in der das Bild gezeichnet wird. 
	 */
	private int height; 
	
	/**
	 * Das {@link Image} das gezeichnet wird. 
	 */
	private Image image; 
	
	/**
	 * Der Rahmen der um das {@link Image} gezeichnet werden soll. 
	 */
	private Image rahmen; 
	/**
	 * Die {@link GameSettings}. 
	 */
	private GameSettings settings; 
	
	/**
	 * Zeichnet die LiveBar. 
	 * @param settings �bergibt die {@link GameSettings} des Aktuellen Spiels. 
	 */
	public LifeBarPrint(GameSettings settings) {
		try {
			image = ImageIO.read(new File("Grafiks/SimpleLivesEbene.png"));
			rahmen = ImageIO.read(new File("Grafiks/Rahmen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		width = image.getWidth(null)*2; 
		height = image.getHeight(null); 
		
		y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - height - 20); 
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
		g.drawImage(image, x, y, (width/100) * settings.getLifes(), height, null); 
		g.drawImage(rahmen, x, y, (width/100) * 100, height, null); 
	
	}
}
