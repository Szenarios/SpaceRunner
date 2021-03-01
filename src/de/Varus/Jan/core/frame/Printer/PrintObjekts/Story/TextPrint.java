package de.Varus.Jan.core.frame.Printer.PrintObjekts.Story;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Moveable;
/**
 * Zeichnet den angebenden Text an die Angegebende Koordinate 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class TextPrint implements Drawable, Moveable {
	/**
	 * Die X Koordinate 
	 */
	private int x; 
	/**
	 * Die Y Koordinate 
	 */
	private int y; 
	
	/**
	 * Ob der Text sich bewegt.
	 */
	private boolean moving = true; 
	
	/**
	 * Der Text der gezeichnet wird. 
	 */
	private ArrayList<String> text = new ArrayList<String>(); 
	
	/**
	 * Zeichnet einen Text der von unten nach oben wandert. 
	 * @param text Der gezeichnete Text in einer {@link ArrayList}
	 */
	public TextPrint(ArrayList<String> text) {
		this.text = text; 
		y = Main.mainFrame.getHeight(); 
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
	public int width() {return 0;}

	@Override
	public int height() {return 0;}

	@Override
	public Image getImage() {return null;}

	@Override
	public void draw(Graphics2D g) {
		int realY; 
		double realX; 
		
		int fontSize = Main.mainFrame.getWidth() >= 1920 ? 64 : 32; 
		
		for (int i = 0; i < text.size(); i++) {
			String zeile = text.get(i); 
			realY = y + (fontSize * i); 

			if(i+1 == text.size())
				if (realY+150 < 0)
					this.moving = false; 
			
			g.setColor(Color.yellow);	
			
			realX = (Main.mainFrame.getWidth() / 2) - (zeile.length() / 2) * (fontSize/2);
			
			g.setFont(new Font("Arial",Font.BOLD,(int) fontSize));
			g.drawString(zeile, (int) realX, realY);
		}
	}

	@Override
	public boolean isMoving() {
		return this.moving;
	}

	@Override
	public Point currentPosition() {
		return null;
	}

	@Override
	public Point lastBreakPosition() {
		return null;
	}

	@Override
	public Point startPosition() {
		return null;
	}

	@Override
	public void move() {
		this.y = this.y - 1;
	}
	
}
