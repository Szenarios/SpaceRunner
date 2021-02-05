package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class MenuPrinter extends JPanel implements IPrinter {

	@Override
	public void registerListeners() {
		
	}

	@Override
	public List<Drawable> getDrawable() {
		return null;
	}

	@Override
	public void drawAll(Graphics2D g) {
		for(Drawable d : getDrawable())
			d.draw(g);
	}
	
	@Override
	public void paint(Graphics g) {
		drawAll((Graphics2D) g);
	}
}
