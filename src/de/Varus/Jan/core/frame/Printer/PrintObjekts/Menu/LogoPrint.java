package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
/**
 * Zeichnet den Logo Banner des Spiels auf Menu. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class LogoPrint implements Drawable {
	/**
	 * Die X Koordinate 
	 */
	private int x; 
	/**
	 * Die Y Koordinate 
	 */
	private int y; 
	/**
	 * Die breite in der, der Banner gezeichnet werden soll. 
	 */
	private int width;
	/**
	 * Die höhe in der, der Banner gezeichnet werden soll. 
	 */
	private int height; 
	
	/**
	 * Das Bild was gezeichnet werden soll. 
	 */
	private Image image;

	/**
	 * Erzeugt den Banner als {@link Image}.
	 */
	public LogoPrint() {
		try {
			image = ImageIO.read(new File("Grafiks/Space_Runner_Logo.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.height = image.getHeight(null)/4 * 3; 
		this.width = image.getWidth(null)/4 * 3; 
		
		this.y = 5;
		this.x = (Main.mainFrame.getWidth() / 2) - (width / 2); 
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
	public Image getImage() {
		return this.image;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, width, height, null); 
	} 
}
