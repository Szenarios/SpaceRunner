package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.BorderManager;
import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.GamePrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Story.StoryPrinter;

public class PlayButtonPrint implements Drawable, Clickable, Runnable {
	/**
	 * Die X Koordinate 
	 */
	private int x; 
	/**
	 * Die Y Koordinate 
	 */
	private int y; 
	
	/**
	 * Die Höhe in der das Bild gezeichnet werden soll. 
	 */
	private int height; 
	/**
	 * Die Breite in der das Bild gezeichnet werden soll. 
	 */
	private int width; 
	
	/**
	 * Das {@link Image} was gezeichnet werden soll.
	 */
	private Image image; 
	/**
	 * Die {@link GameSettings} mit denen das Spiel gestartet wird. 
	 */
	private GameSettings settings; 
	
	/**
	 * Zeichnet einen Button der das Spiel startet. 
	 * @param settings
	 */
	public PlayButtonPrint(GameSettings settings) {
		this.settings = settings; 
		
		try {
			image = ImageIO.read(new File("Grafiks/FinalPlayButton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 

		height = image.getHeight(null) / 4 * 3; 
		width = image.getWidth(null) / 4 * 3; 
		
		x = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - (width/2)); 
		y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 5)*3;
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


	@Override
	public void run() {
		if(settings.isStoryShown())
			Main.switchPrinter(new GamePrinter(settings));
		else 
			Main.switchPrinter(new StoryPrinter(settings));
	}

}
