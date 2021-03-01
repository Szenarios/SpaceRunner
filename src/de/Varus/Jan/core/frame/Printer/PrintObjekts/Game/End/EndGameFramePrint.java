package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.End;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

/**
 * Zeichnet das Game Over Frame. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class EndGameFramePrint implements Drawable {
	/**
	 * Ob der Sound bereits abgespielt wurde. 
	 */
	private boolean played; 
	
	/**
	 * Das Image was gezeichnet werden soll. 
	 */
	private Image image; 
	
	/**
	 * Die X Koordinate. 
	 */
	private int x; 
	/**
	 * Die Y Koordinate. 
	 */
	private int y; 
	/**
	 * Die Breite in dem das Bild gezeichnet werden soll. 
	 */
	private int width; 
	/**
	 * Die Höhe in dem das Bild gezeichnet werden soll. 
	 */
	private int height; 
	
	/**
	 * Zeichnet ein Gmae Over Frame. 
	 */
	public EndGameFramePrint() {
		try {
			image = ImageIO.read(new File("Grafiks/GameOverFrame.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		width = image.getWidth(null); 
		height = image.getHeight(null); 
		
		x = 0; 
		y = 0; 
		
		played = false; 
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
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		if(!played) {
			played = true; 
			Main.musikPlayer.playGameOverSound();
		}
			
		
		g.drawImage(image, x, y, width, height, null); 
	}

}
