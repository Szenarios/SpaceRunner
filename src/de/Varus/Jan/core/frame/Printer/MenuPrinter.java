package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Background;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.BSettingsPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.BackgroundPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.PlayButtonPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow.ArrowInterface;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow.ArrowPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow.ArrowRotation;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.DifficultyPrint;

public class  MenuPrinter extends JPanel implements IPrinter, MouseListener {
	private List<Drawable> drawables = new ArrayList<>(); 
	public MenuPrinter() {
		DifficultyPrint difficultyPrint = new DifficultyPrint(); 
		registerDrawable(new BackgroundPrint(), new BSettingsPrint(), difficultyPrint, new ArrowPrint(ArrowRotation.ARROWLEFT, difficultyPrint), new ArrowPrint(ArrowRotation.ARROWRIGHT, difficultyPrint), new PlayButtonPrint());
	}	
	
	@Override
	public void registerListeners(JFrame frame) {
		frame.addMouseListener(this);
	}
	@Override
	public void unregisterListeners(JFrame frame) {
		frame.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent event) {
		for(Drawable d : getDrawable()) {
			if(d instanceof Clickable) {
				((Clickable)d).checkAndRun(event.getX(), event.getY());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseExited(MouseEvent event) {}

	@Override
	public void mousePressed(MouseEvent event) {}

	@Override
	public void mouseReleased(MouseEvent event) {}

}
