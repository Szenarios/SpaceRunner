package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Collideable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Moveable;

public class SpaceShipPrint implements Drawable, Moveable, Collideable {
	/**
	 * Das Row {@link Image} was alle Texturen des Spaceships beinhaltet. 
	 */
	private Image image; 
	/**
	 * Das Row {@link Image} als {@link BufferedImage}.
	 */
	private BufferedImage bufferedImage; 
	
	/**
	 * Der {@link Point} wo das {@link SpaceShipPrint} gestartet hat. 
	 */
	private Point startPositon; 
	/**
	 * Der {@link Point} wo das {@link SpaceShipPrint} als letztes eine Pause gemacht hat. 
	 */
	private Point lastBreakPositon; 
	
	/**
	 * Die X Koordinate 
	 */
	private int x; 
	/**
	 * Die Y Koordinate 
	 */
	private int y; 
	
	/**
	 * Die Y Kordinate auf dem Row Image für die Verschieden Texturen des Raumschiffes (Von 0-1400 in 200 Schritten)
	 */
	private int stateY; 
	
	/**
	 * Die Breite in der das {@link Image} gezeichnet werden soll. 
	 */
	private int wight; 
	/**
	 * Die Höhe in der das {@link Image} gezeichnet werden soll. 
	 */
	private int height; 
	
	/**
	 * Die Rotation des {@link SpaceShipPrint} (Momentan nicht benutzt wegen Fehlender Texturen)
	 */
	private SpaceShipState state = SpaceShipState.GERADE;
	/**
	 * Die {@link Direction} in die sich das {@link SpaceShipPrint} bewegt. 
	 */
	private Direction direction = Direction.FORWORT; 
	/**
	 * Der Wert ob sich das {@link SpaceShipPrint} gerade bewegt oder nicht.
	 */
	private boolean moving = false; 
	/**
	 * Zeichnet das SpaceShip und Animiert es. 
	 */
	public SpaceShipPrint() {
		try {
			image = ImageIO.read(new File("Grafiks/SpaceShip.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.wight = 255; 
		this.height = 255; 
		
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
		
		// Pro Zeichnung wird der stateY wert immer um 100 gerechnet um ein Anders Image zu Zeichenn. 
		stateY+= 100; 
		if(stateY >= 1400) {
			stateY = 0; 
		}
		
		// Dieser wert wird geteilt durch 200 und Mal 200 Gerechnet um nicht bei jeder neuen Aufruf eine Anderen Texture zu erzeugen sondern nur alle paar Aufrufen. 
		g.drawImage(bufferedImage.getSubimage(0, (stateY / 200)*200, 200, 200), x, y, wight, height, null); 
	
		g.drawRect((int)getHitbox().getX(), (int)getHitbox().getY(), (int)getHitbox().getWidth(), (int)getHitbox().getHeight());
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
	
	/**
	 * Setzt das Raumschiff in Bewegung. Für alle kommende Aufrufe der draw Methode wird es sich nun in die angebende Richtung bewegen.
	 * @param direction gibt die Richtung an in die sich das SpaceShip bewegen soll. 
	 */
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
	/**
	 * Bebende die Bewegung des SpaceShips. 
	 * @param direction die Angebende Richtung in die, die Bewegung gestop werden soll. 
	 */
	public void endMove(Direction direction) {
		/*
		 * Sollte das Raumschiff sich ohne zu Stoppen in einer Andere Richtung 
		 * bewegt haben würde beides Abgebrochen, durch die Abfrage wird nur 
		 * abgebrochen wenn es immer noch in die selbe Richtung Fliegt. 
		 */
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
		int move = 45; 
		if(lastBreakPosition().distance(x, y) > 150) {
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


	@Override
	public Rectangle getHitbox() {
		return new Rectangle(x + ((wight /2) - (wight / 4)), y, wight/2, height); 
	}
}
