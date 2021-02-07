package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class DifficultyPrint implements Drawable {
	int x; 
	int y; 
	int height; 
	int width; 
	
	private Difficulty difficulty = Difficulty.NORMAL; 
	private Image hard; 
	private Image normal; 
	private Image easy; 
	public DifficultyPrint() {
		this.difficulty = Main.difficulty; 
		try {
			hard = ImageIO.read(new File("Grafiks/DifficultiHard.png"));
			easy = ImageIO.read(new File("Grafiks/DifficultiEasy.png"));
			normal = ImageIO.read(new File("Grafiks/DifficultiNormal.png"));
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
	
	public void goUp() {
		for(Difficulty difficulty : Difficulty.values()) {
			if (difficulty.getPosition() == (this.difficulty.getPosition() +1)) {
				this.difficulty = difficulty; 
				break; 
			}
		}
	}
	public void goDown() {
		for(Difficulty difficulty : Difficulty.values()) {
			if (difficulty.getPosition() == (this.difficulty.getPosition() -1)) {
				this.difficulty = difficulty; 
				break; 
			}
		}
	}

}