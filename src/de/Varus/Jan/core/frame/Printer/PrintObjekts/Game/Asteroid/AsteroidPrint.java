package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid;

import java.awt.Color;
import java.awt.Dimension;
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

public class AsteroidPrint implements Drawable, Moveable, Collideable {
	/**
	 * Einzelne Texture als Image
	 */
	private Image image; 
	
	/**
	 * Alle Neun Asteroiden Texture als Image
	 */
	private static Image rowImage; 
	
	/**
	 * X Koordinate 
	 */
	private int x;
	/** 
	 * Y Koordinate 
	 */
	private int y; 
	
	/**
	 * Wie Hoch das Bild gezeichnet werden soll. 
	 */
	private int height; 
	/**
	 * Wie Breit das Bild gezeichnet werden soll. 
	 */
	private int width;
	
	/**
	 * Ob sich der Asteroid bewegt oder nicht. 
	 */
	private boolean moving = true; 
	
	/**
	 * An welchen {@link Point} der Asteroid gestartet ist. 
	 */
	private Point startPos; 
	/**
	 * An welchem {@link Point} der Asteroid zu letzt pasuiert ist. 
	 */
	private Point lastPos;
	
	/**
	 * Ob der Asteroid zerstört wurde oder nicht. 
	 */
	private boolean destroyed; 
	/** 
	 * Zwischengespeicherte Asteroiden die zur Destroy Animation gebraucht werden. 
	 */
	private SmallAsteroidPrint[] smallAsteroieds; 

	/**
	 * Der {@link SimpleVektor} der die Richtung des Asteroiden angibt. 
	 */
	public SimpleVektor vektor; 
	/**
	 * Ein zu Zeichnender Asteroid. 
	 * @param image Die einzekne Texture des Asteoriden. 
	 * @param vektor Der {@link SimpleVetkor} der die Richtung in der er sich bewegt angibt. 
	 * @param start Wo der Asteroid starten soll. 
	 * @param size Wie groß der Asteroid seien soll. 
	 */
	public AsteroidPrint(Image image, SimpleVektor vektor, Point start, Dimension size) {
		this.vektor = vektor; 
		this.image = image; 
		
		this.x = (int) start.getX(); 
		this.y = (int) start.getY(); 
		
		this.height = (int) size.getHeight(); 
		this.width = (int) size.getWidth(); 
	}
	@Override
	public boolean isMoving() {
		if (!isDestroyed())
			return y > Toolkit.getDefaultToolkit().getScreenSize().getHeight() ? false : true; 
		return moving;
	}

	@Override
	public Point currentPosition() {
		return new Point(x, y);
	}

	@Override
	public Point lastBreakPosition() {
		return lastPos;
	}

	@Override
	public Point startPosition() {
		return startPos;
	}

	@Override
	public void move() {
		this.x = x + vektor.getX(); 
		this.y = y + vektor.getY(); 
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
		return width;
	}

	@Override
	public int height() {
		return height;
	}
	
	@Override
	public Rectangle getHitbox() {
		int cutWidth = width / 10; 
		int cutHeight = height / 10; 
		return new Rectangle(x+cutWidth, y+6, width-(cutWidth*3), height-(cutHeight*3));
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics2D g) {
		// Wenn er sich nicht mehr Bewegt ist er aushalb des Bildschirms also wird er nicht gezeichnet!
		if(isMoving())
			// Wenn er nicht zerstört ist wird er gezeichnet!
			if(!isDestroyed()) {
				g.drawImage(image, x, y, width, height, null); 
				g.setColor(Color.white);
				g.drawRect(x, y, width, height);
				g.setColor(Color.red);
				g.drawRect((int)getHitbox().getX(), (int)getHitbox().getY(), (int)getHitbox().getWidth(), (int)getHitbox().getHeight());
			} else {
				/**
				 * Die SmallAsteroieds werden generiert wenn diese noch nicht Exestieren. 
				 * Anschließend werden sie gezeichnet und bewegen sich je nach Richtungs Vektor 
				 * in verschiede Richtungen. Sollten diese zu weit weg von dem Ursprungs Punkt 
				 * sein verschwienden sie. 
				 */
				if(smallAsteroieds == null) 
					generateSmallAsteroids();
				
				if(smallAsteroieds[0].currentPosition().distance(this.currentPosition()) > 575) 
					this.moving = false; 
				
				for (SmallAsteroidPrint smallAsteroidPrint : smallAsteroieds) {
					g.drawImage(smallAsteroidPrint.getImage(), smallAsteroidPrint.x(), smallAsteroidPrint.y(), smallAsteroidPrint.width(), smallAsteroidPrint.height(), null); 
					smallAsteroidPrint.move();
				}
				
			}
	}
	
	/**
	 * Füllte den smallAsteroieds Array mit kleinen Random Asteroiden. 
	 */
	public void generateSmallAsteroids() {
		smallAsteroieds = new SmallAsteroidPrint[6];
		for (int i = 0; i < smallAsteroieds.length; i++) {
			smallAsteroieds[i] = new SmallAsteroidPrint(new Point(this.currentPosition().x + (this.width / 2), this.currentPosition().y + (this.height / 2))); 
			System.out.println(smallAsteroieds[i].vektor.toString());
		}
	}
	
	/**
	 * Gibt zurück ob der Asteroid zerstört ist. 
	 * @return {@link Boolean} true wenn der Asteroid zerstört ist. 
	 */
	public boolean isDestroyed() {
		return destroyed;
	}
	/**
	 * Setzt den Asteroiden als Zerstört. 
	 */
	public void Destroy() {
		this.destroyed = true; 
	}
	
	/**
	 * Gibt ein Random image aus dem RowImage zurück. 
	 * @return Gibt ein Image aus einem der 9 Asteroiden Texturen aus. 
	 */
	public static Image getRandomImage() {
		if(rowImage == null) {
			try {
				rowImage = ImageIO.read(new File("Grafiks/Asteroid.png"));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		BufferedImage singleAsteroid = (BufferedImage) rowImage;

		int rdmY = (int) (Math.random() * 2 + 0); 
		int rdmX = (int) (Math.random() * 2 + 0); 
		
		return singleAsteroid.getSubimage(rdmX*225, rdmY*225, 225, 225); 
	}
}
