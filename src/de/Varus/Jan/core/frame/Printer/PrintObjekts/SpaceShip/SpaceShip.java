package de.Varus.Jan.core.frame.Printer.PrintObjekts.SpaceShip;

import java.awt.Graphics2D;
import java.awt.Image;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class SpaceShip implements Drawable {
	private Image image; 
	private int x; 
	private int y; 
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

}
