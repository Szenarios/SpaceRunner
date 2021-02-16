package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.MenuPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;
import de.Varus.Jan.core.managing.BorderManager;

public class ArrowPrint implements Drawable, Clickable, Runnable{
	private int x; 
	private int y; 
	private int width; 
	private int heigt; 
	
	private ArrowRotation rotation;
	private MenuPrinter printer; 
	private Image image; 
		
	public ArrowPrint(ArrowRotation rotation, MenuPrinter printer) {
		this.printer = printer; 
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
			goUp();
			break;
		case ARROWLEFT: 
			goDown();
			break; 
		default:
			break;
		}
	}
	
	public void goUp() {
		Difficulty difficulty = printer.getDifficulty(); 
		for(Difficulty difficultys : Difficulty.values()) {
			if (difficultys.getPosition() == (difficulty.getPosition() +1)) {
				printer.setDifficulty(difficultys);
				break; 
			}
		}
	}
	public void goDown() {
		Difficulty difficulty = printer.getDifficulty(); 
		for(Difficulty difficultys : Difficulty.values()) {
			if (difficultys.getPosition() == (difficulty.getPosition() -1)) {
				printer.setDifficulty(difficultys);
				break; 
			}
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
