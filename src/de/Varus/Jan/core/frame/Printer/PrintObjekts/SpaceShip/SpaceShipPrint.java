package de.Varus.Jan.core.frame.Printer.PrintObjekts.SpaceShip;

import java.awt.Graphics2D;
import java.awt.Image;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class SpaceShipPrint implements Drawable {
	private Image image; 
	private int x; 
	private int y; 
	private int wight; 
	private int height; 
	private SpaceShipState state; 
	
	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		switch (state) {
		case GERADE:
			g.drawImage(image, x, y, null); 
			break;
		case LEICHT_LINKS:
			// TODO 
			break;
		case LEICHT_RECHTS:
			// TODO 
			break;
		case STARK_LINKS:
			// TODO 
			break;
		case STARK_RECHTS:
			// TODO 
			break;
		default:
			state = SpaceShipState.GERADE; 
			break;
		}
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

}
