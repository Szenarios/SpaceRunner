package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.BorderManager;
import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

/**
 * Erstellt einen Button mit eigener Texture und Runnable. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class ButtonPrint implements Drawable, Clickable {
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
	int height; 
	/**
	 * Die Breite in der das Bild gezeichnet werden soll. 
	 */
	int width; 
	/**
	 * Das Bild was gezeichnet werden soll. 
	 */
	private Image image; 

	
	/**
	 * Das Runnable was ausgeführt wird wenn der Button gedrückt wird. 
	 */
	private Runnable runnable; 
	
	/**
	 * Zeichnet einen Button. 
	 * @param pfad Der Pfad des Image des Buttons
	 * @param run Der Runnable der ausgeführt wird wenn der Button gedrückt wird.
	 * @param numberDesButons Welcher button das ist.
	 */
	public ButtonPrint(String pfad, Runnable run, int numberDesButons) {
		try {
			image = ImageIO.read(new File(pfad));
		} catch (IOException e) {
			image = null; 
			e.printStackTrace();
		} 
		this.width = 55; 
		this.height = 55;
		this.x = (int) (Main.mainFrame.getSize().getWidth() - (width * numberDesButons) - (10 * numberDesButons)); 
		this.y = (int) 10; 
		
		image = image.getScaledInstance(width, height, 0); 
		this.runnable = run; 
	
		/*
		 * Sollte es zu viele Buttons werden und die X Koordinate 
		 * ins Negative gehen kann dieser Button nicht gezeichnet 
		 * werden wodruch der gesammte Printer Einfriert. 
		 */
		if(x < 0)
			throw new NumberFormatException("Die Anzahl der Button ist zu Groß für den Bildschirm!");
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
			perfrom(this.runnable);
	}
	
	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, null); 
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
}