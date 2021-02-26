package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.MenuPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class DifficultyPrint implements Drawable {
	/**
	 * Die X Koordinate 
	 */
	int x; 
	/**
	 * Die Y Koordinate 
	 */
	int y; 
	/**
	 * Die Höhe in der das Bild gezeichnet werden soll. 
	 */
	int height; 
	/** 
	 * Die Breite in der das Bild gezeichnet werden soll. 
	 */
	int width; 
	
	/**
	 * Der Difficulty der gezeichnet werden soll. 
	 */
	private Difficulty difficulty; 
	/**
	 * Der zuständige Menu Printer. 
	 */
	private MenuPrinter printer;
	/**
	 * Das {@link Image} für den "Hard" Difficulty.
	 */
	private Image hard; 
	/**
	 * Das {@link Image} für den "Normal" Difficulty.
	 */
	private Image normal; 
	/**
	 * Das {@link Image} für den "Easy" Difficulty.
	 */
	private Image easy; 
	/**
	 * Zeichnet je nach Difficulty diesen entsprechend. 
	 * @param printer Der zuständige MenuPrinter. 
	 */
	public DifficultyPrint(MenuPrinter printer) {
		this.difficulty = printer.getDifficulty();; 
		this.printer = printer; 
		try {
			hard = ImageIO.read(new File("Grafiks/FinalDifficultiHard.png"));
			easy = ImageIO.read(new File("Grafiks/FinalDifficultiEasy.png"));
			normal = ImageIO.read(new File("Grafiks/FinalDifficultiNormal.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		height = hard.getHeight(null) / 3 * 2; 
		width = hard.getWidth(null) / 3 * 2; 
		
		x = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - (width/2)); 
		y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);
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
		this.difficulty = printer.getDifficulty(); 
		
		switch (difficulty) {
		case EASY:
			return easy; 
		case NORMAL: 
			return normal; 
		case HARD: 
			return hard; 
		default:
			return normal; 
		}
		
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getImage(), x, y, width, height, null); 
	}
}
