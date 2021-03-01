package de.Varus.Jan.core.frame.Printer.PrintObjekts.Credit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class AbsatzPrint implements Drawable {

	/**
	 * Die Y Koordinate 
	 */
	private int y; 
	
	/**
	 * Die Überschft des Absatzes 
	 */
	private String überschrift; 
	/**
	 * Die Namen die in diesem Absatz genannt werden. 
	 */
	private String[] namen; 
	
	public AbsatzPrint(int y, String überschrift, String... namen) {
		this.überschrift = überschrift; 
		this.namen = namen; 
		
		this.y = y; 
	} 
	
	@Override
	public int x() {
		return 0;
	}

	@Override
	public int y() {
		return this.y;
	}

	@Override
	public int width() {
		return 0;
	}

	@Override
	public int height() {
		return 0;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public void draw(Graphics2D g) {
		int secY = y() + 60; 
		drawÜberschrift(überschrift, y(), g);
		for (int i = 0; i < namen.length; i++) {
			drawText(namen[i], secY, g);
			secY = secY + 32; 
		}
	}
	
	/**
	 * Zeichne eine Überschrift. 
	 * @param überschrift Der Text der als Überschrift gezeichnet wird. 
	 * @param y Die Y Koordinate an die, die Überschrift gezichnet wird. 
	 * @param g Das {@link Graphics2D} auf das gezeichnet wird.
	 */
	private void drawÜberschrift(String überschrift, int y, Graphics2D g) {
		g.setFont(new Font("Arial",Font.BOLD,(int) 60));
		int x = (Main.mainFrame.getWidth() / 2) - (überschrift.length() / 2) * (g.getFont().getSize() / 2);
		
		g.setColor(Color.ORANGE);
		g.drawString(überschrift, (int) x+3, y-3);
		g.setColor(Color.WHITE);
		g.drawString(überschrift, (int) x, y);
	}
	
	/**
	 * Zeichne einen Text. 
	 * @param text Der Text der gezeichnet wird. 
	 * @param y Die Y Koordinate an die, die Überschrift gezichnet wird. 
	 * @param g Das {@link Graphics2D} auf das gezeichnet wird.
	 */
	private void drawText(String text, int y, Graphics2D g) {
		g.setFont(new Font("Arial",Font.BOLD,(int) 32));
		int x = (Main.mainFrame.getWidth() / 2) - (text.length() / 2) * (g.getFont().getSize() / 2);
		
		g.setColor(Color.black);
		g.drawString(text, (int) x+1, y-1);
		g.setColor(Color.WHITE);
		g.drawString(text, (int) x, y);
	}

}
