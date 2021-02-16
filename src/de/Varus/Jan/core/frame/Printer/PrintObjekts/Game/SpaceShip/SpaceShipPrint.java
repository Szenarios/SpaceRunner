package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class SpaceShipPrint implements Drawable {
	private Image image; 
	private BufferedImage bufferedImage; 
	
	private int x; 
	private int y; 
	
	private int stateY; ; 
	
	private int wight; 
	private int height; 
	
	private SpaceShipState state = SpaceShipState.GERADE; 
	private Direction direction = Direction.FORWORT; 
	private boolean moving = false; 
	public SpaceShipPrint() {
		try {
			image = ImageIO.read(new File("Grafiks/SpaceShip.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 100); 
		x = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 8) * 6); 
		bufferedImage = (BufferedImage) image; 
	}
	
	
	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		if(moving) {
			move(50, this.direction);
		}
		
		
		stateY+= 25; 
		if(stateY >= 1400) {
			stateY = 0; 
		}
		g.drawImage(bufferedImage.getSubimage(state.get(), (stateY / 200)*200, 200, 200), x, y, 200, 200, null); 
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
		return this.wight;
	}

	@Override
	public int height() {
		return this.height;
	}
	
	
	public void startSlowMove(Direction direction) {
		this.moving = true; 
		this.direction = direction; 
		switch (direction) {
		case RIGHT:
			state = SpaceShipState.LEICHT_RECHTS;
			break;
		case LEFT: 
			state = SpaceShipState.LEICHT_LINKS; 
			break; 
		default:
			break;
		}
	}
	public void endSlowMove(Direction direction) {
		if(this.direction == direction) {
			this.moving = false; 
			this.direction = Direction.FORWORT; 
			this.state  = SpaceShipState.GERADE; 
		}
	}
	public void superMove(Direction direction) {
		move(150, direction);
		switch (direction) {
		case RIGHT:
			state = SpaceShipState.STARK_RECHTS;
			break;
		case LEFT: 
			state = SpaceShipState.STARK_LINKS; 
			break; 
		default:
			break;
		}
		
//		this.moving = false; 
//		this.direction = Direction.FORWORT; 
	}
	
	
	private void move(int move, Direction direction) {
		switch (direction) {
		case RIGHT:
			int x1 = x + move; 
			if(x1 < Toolkit.getDefaultToolkit().getScreenSize().getWidth()) {
				this.x = x + move; 
			}
			break;
		case LEFT: 
			int x2 = x - move; 
			if(x2 > 0) {
				this.x = x - move; 
			}
			break; 
		default:
			break;
		}
	}
	

}
