package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Background;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class BackgroundPrint implements Drawable, Background {
	private Image image; 
	boolean print = true; 
	public BackgroundPrint() {
		try {
			image = ImageIO.read(new File("Grafiks/Hintergrund.png"));
		} catch (IOException e) {
			// TODO 
			e.printStackTrace();
		} 
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
		g.drawImage(image, x(), y(), null); 
		print = false; 
	}

	@Override
	public boolean print() {
		return print;
	}
	
	public void setToPrint() {
		setPrint(true);
	}

	@Override
	public void setPrint(boolean print) {
		this.print = print; 
	}

}
