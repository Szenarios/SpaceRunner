package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class ScrollingBackgroundPrint implements Drawable {
	
	private int scrollingPX = 10; 
	private Image image; 
	int cutY = 0; 

	
	private BufferedImage bufferedImage; 
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
			if(cutY < getImage().getHeight(null)) {
				g.drawImage(
						bufferedImage.getSubimage(0, 0, width(), height() - emptySpace), 
						0, emptySpace, width(), height() - emptySpace, null);
			} else {
				cutY = 0; 
			}
		}
		cutY+= scrollingPX; 
	}


}