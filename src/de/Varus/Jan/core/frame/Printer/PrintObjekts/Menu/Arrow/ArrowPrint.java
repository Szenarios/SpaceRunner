package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.DifficultyPrint;
import de.Varus.Jan.core.managing.BorderManager;

public class ArrowPrint implements Drawable, Clickable, Runnable{
	private int x; 
	private int y; 
	private int width; 
	private int heigt; 
	
	private ArrowRotation rotation;
	private DifficultyPrint difficultyPrint; 
	private Image image; 
		
	public ArrowPrint(ArrowRotation rotation, DifficultyPrint difficultyPrint) {
		this.difficultyPrint = difficultyPrint; 
		this.rotation = rotation; 
		try {
			switch (rotation) {
			case ARROWLEFT:
				image = ImageIO.read(new File("Grafiks/PfeilLinks.png"));
				break;
			case ARROWRIGHT:
				image = ImageIO.read(new File("Grafiks/PfeilRechts.png"));
				break;
			default:
				// TODO 
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		width = image.getWidth(null); 
		heigt = image.getHeight(null); 
		
		x = (int) (((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 7)*(rotation == ArrowRotation.ARROWLEFT ? 2 : 5)) - (width/2)); 
		y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);
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
	public void run() {
		switch (rotation) {
		case ARROWRIGHT:
			difficultyPrint.goUp();
			break;
		case ARROWLEFT: 
			difficultyPrint.goDown();
			break; 
		default:
			break;
		}
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
		return heigt;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, x,y, null); 
	}


}
