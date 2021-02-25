package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Background;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class ScrollingBackgroundPrint implements Drawable, Background {
	
	/**
	 * Die Pixel um die sich der Hintergrund bewegt pro Aufruf
	 */
	private int scrollingPX = 10; 
	/**
	 * Das Hintergrund {@link Image}
	 */
	private Image image; 
	
	/** 
	 * Die Y Koordinate auf dem Row Image
	 */
	int cutY = 0; 
	
	/**
	 * Ob der Hintergrund gezeichnet werden soll (Alsways true)
	 */
	private boolean print = true; 

	/**
	 * Das Row {@link Image} als {@link BufferedImage}. 
	 */
	private BufferedImage bufferedImage; 
	/**
	 * Zeichnet und Animiert einen Hintergrund. 
	 */
	public ScrollingBackgroundPrint() {
		try {
			image = ImageIO.read(new File("Grafiks/ScrollingBackground.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		bufferedImage = (BufferedImage) image; 
	}
	
	@Override
	public int x() {
		return 0;
	}

	@Override
	public int y() {
		return 0;
	}

	@Override
	public int width() {
		return Main.mainFrame.getWidth();
	}

	@Override
	public int height() {
		return Main.mainFrame.getHeight();
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		int emptySpace = getImage().getHeight(null) - cutY; 
		if(emptySpace != 0) {
			g.drawImage(bufferedImage.getSubimage(0, cutY, width(), (cutY + height()) > getImage().getHeight(null) ? emptySpace: height()), 0, 0, width(), (cutY + height()) > getImage().getHeight(null) ? emptySpace: height(), null); 
		}
		if((cutY + height()) > getImage().getHeight(null)) {
			if(cutY < getImage().getHeight(null)) { // Der Übergang zwischen den Hintergrund Bildern. 
				g.drawImage(
						bufferedImage.getSubimage(0, 0, width(), height() - emptySpace), 
						0, emptySpace, width(), height() - emptySpace, null);
			} else {
				cutY = 0; 
			}
		}
		cutY+= scrollingPX; 
	}

	@Override
	public boolean print() {
		return print;
	}

	@Override
	public void setPrint(boolean print) {
		this.print = print; 
	}


}
