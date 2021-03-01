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
	 * Die �berschft des Absatzes 
	 */
	private String �berschrift; 
	/**
	 * Die Namen die in diesem Absatz genannt werden. 
	 */
	private String[] namen; 
	
	public AbsatzPrint(int y, String �berschrift, String... namen) {
		this.�berschrift = �berschrift; 
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
		draw�berschrift(�berschrift, y(), g);
		for (int i = 0; i < namen.length; i++) {
			drawText(namen[i], secY, g);
			secY = secY + 32; 
		}
	}
	
	/**
	 * Zeichne eine �berschrift. 
	 * @param �berschrift Der Text der als �berschrift gezeichnet wird. 
	 * @param y Die Y Koordinate an die, die �berschrift gezichnet wird. 
	 * @param g Das {@link Graphics2D} auf das gezeichnet wird.
	 */
	private void draw�berschrift(String �berschrift, int y, Graphics2D g) {
		g.setFont(new Font("Arial",Font.BOLD,(int) 60));
		int x = (Main.mainFrame.getWidth() / 2) - (�berschrift.length() / 2) * (g.getFont().getSize() / 2);
		
		g.setColor(Color.ORANGE);
		g.drawString(�berschrift, (int) x+3, y-3);
		g.setColor(Color.WHITE);
		g.drawString(�berschrift, (int) x, y);
	}
	
	/**
	 * Zeichne einen Text. 
	 * @param text Der Text der gezeichnet wird. 
	 * @param y Die Y Koordinate an die, die �berschrift gezichnet wird. 
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
