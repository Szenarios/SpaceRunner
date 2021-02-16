package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.frame.Listener.PrintKeyListener;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Background;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.LifeBarPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBarPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ScrollingBackgroundPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.SpaceShipPrint;

public class GamePrinter extends JPanel implements IPrinter {
	private List<Drawable> drawables = new ArrayList<>(); 
	private SpaceShipPrint spaceShipPrint; 
	private PrintKeyListener listener; 
	// TODO Key Listener 
	public GamePrinter() { // Difficulty 
		spaceShipPrint = new SpaceShipPrint(); 
		listener = new PrintKeyListener(spaceShipPrint); 
		registerDrawable(new ScrollingBackgroundPrint(), spaceShipPrint,new LifeBarPrint(), new PowerBarPrint());
	}
	
	@Override
	public void registerListeners(JFrame frame) {
		frame.addKeyListener(listener);
	}
	@Override
	public void unregisterListeners(JFrame frame) {
		frame.removeKeyListener(listener);
	}
	
	
	@Override
	public List<Drawable> getDrawable() {
		return drawables;
	}

	@Override
	public void drawAll(Graphics2D g) {
		for(Drawable d : getDrawable()) {
			if(d instanceof Background) {
				if(((Background) d).print()) {
					d.draw(g);
				}
			} else {
				d.draw(g);
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		drawAll((Graphics2D) g);
	}

	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			this.drawables.add(d); 
	}


}
