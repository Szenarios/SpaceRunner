package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.SecureCacheResponse;

import javax.imageio.ImageIO;


import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Moveable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBarPrint;

public class SpaceShipPrint implements Drawable, Moveable {
	private Image image; 
	private BufferedImage bufferedImage; 
	
	private Point startPositon; 
	private Point lastBreakPositon; 
	
	
	private int x; 
	private int y; 
	
	private int stateY; 
	
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
		
		startPositon = new Point(x, y); 
		lastBreakPositon = startPositon; 
		
	}
	
	
	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		if(isMoving()) {
			move();
		}
		
		
		stateY+= 100; 
		if(stateY >= 1400) {
			stateY = 0; 
		}
		g.drawImage(bufferedImage.getSubimage(0, (stateY / 200)*200, 200, 200), x, y, 250, 250, null); 
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
	
	
	public void startMove(Direction direction) {
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
	public void endMove(Direction direction) {
		if(this.direction == direction) {
			this.moving = false; 
			this.direction = Direction.FORWORT; 
			this.state  = SpaceShipState.GERADE; 
			this.lastBreakPositon = currentPosition(); 
		}
	}
	

	@Override
	public boolean isMoving() {
		return moving;
	}


	@Override
	public Point currentPosition() {
		return new Point(x, y);
	}


	@Override
	public Point lastBreakPosition() {
		return lastBreakPositon;
	}


	@Override
	public Point startPosition() {
		return startPositon;
	}


	@Override
	public void move() {
		int move = 50; 
		
		if(lastBreakPosition().distance(x, y) > 155) {
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
		}
		
		if(state == SpaceShipState.LEICHT_LINKS || state == SpaceShipState.LEICHT_LINKS) {
			move = 45; 
		} else 
		if(state == SpaceShipState.STARK_LINKS || state == SpaceShipState.STARK_RECHTS) {
			move = 75; 
		}
		
		
		switch (direction) {
		case RIGHT:
			int x1 = x + move; 
			if(x1 < (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - width())) {
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
