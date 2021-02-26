package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.End;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.Test.TestDrawable;
import de.Varus.Jan.core.BorderManager;
import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.MenuPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;

public class ReplayButtonPrint implements Drawable, Clickable, Runnable {
	/**
	 * Die X Koordinate 
	 */
	private int x; 
	/**
	 * Die Y Koordinate 
	 */
	private int y; 
	/**
	 * Die Breite in der das {@link Image} gezeichnet wird. 
	 */
	private int width; 
	/**
	 * Die Höhe in der das {@link Image} gezeichnet wird. 
	 */
	private int height; 
	
	/**
	 * Das {@link Image} was gezeichnet werden soll
	 */
	private Image image; 
	/**
	 * Die {@link GameSettings} von dem verlorenden Spiel
	 */
	private GameSettings settings;
	/**
	 * Zeichnet den Replay Knopf
	 * @param dimension Die Größe des GameOver Frames 
	 */
	/**
	 * Die Größe des Game OVer Frames 
	 */
	private Dimension dimension; 
	public ReplayButtonPrint(GameSettings settings, Dimension dimension) {
		try {
			image = ImageIO.read(new File("Grafiks/ReplayButton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.settings = settings; 
		this.dimension = dimension; 
		
		this.height = image.getHeight(null); 
		this.width = image.getWidth(null); 
		
		this.x = (int) (dimension.getWidth() / 2 - (width / 2)); 
		this.y = (int) (dimension.getHeight() / 3)*2 ; 
		
	}
	
	@Override
	public void run() {
		settings.reset();
		Main.switchPrinter(new MenuPrinter(settings));
	}

	@Override
	public void perfrom(Runnable run) {
		run.run();
	}

	@Override
	public boolean check(int x, int y) {
		// Die Echten Koordinaten auf dem Main Frame 
		int realX  = (Main.mainFrame.getWidth() / 2 - (this.dimension.width / 2)) + this.x; 
		System.out.println();
		int realY = (Main.mainFrame.getHeight() / 2 - (this.dimension.height / 2)) + this.y;
		System.out.println("Rally: " + realX + " " + realY);
		return BorderManager.cordinateInside(new TestDrawable(realX, realY, this.width, this.height), x, y);
	}

	@Override
	public void checkAndRun(int x, int y) {
		System.out.println("Click: " + x + " " + y);
		System.out.println(check(x, y));
		if(check(x, y))
			if(settings.getLifes() <= 0)
				run();
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
