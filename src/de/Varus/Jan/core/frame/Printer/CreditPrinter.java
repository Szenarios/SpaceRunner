package de.Varus.Jan.core.frame.Printer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Credit.AbsatzPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.BackgroundPrint;
/**
 * Der Credit Prinzer
 * @author Szenarios
 * @version F1.03.21
 */
public class CreditPrinter extends JPanel implements IPrinter, KeyListener{
	/**
	 * Die {@link Drawable} die gezeichnet werden sollen. 
	 */
	private ArrayList<Drawable> drawables = new ArrayList<>(); 
	/**
	 * Die Aktuellen GameSettinhs
	 */
	private GameSettings settings; 
	
	/**
	 * Erzeugt einen Printer der die Credits auf das {@link MainFrame} zeichnet. 
	 * @param settings Die Aktuellen {@link GameSettings}.
	 */
	public CreditPrinter(GameSettings settings){
		this.settings = settings; 
		
		int sekment = Main.mainFrame.getHeight() / (Main.mainFrame.getWidth() >= 1920 ? 30 : 15);
		
		registerDrawable(
		new AbsatzPrint(sekment*2, "Programmierung", "Jan Lucas Zimmermann"), 
		new AbsatzPrint(sekment*6, "Grafiken", "Elias B.", "Kayleigh M.", "Jan Lucas Zimmermann"),
		new AbsatzPrint(sekment*(6+7), "Musik", "Max G."),
		new AbsatzPrint(sekment*(6+7+5), "Story", "Kayleigh M.", "Jan Lucas Zimmermann"),
		new AbsatzPrint(sekment*(6+7+6+5), "Mitwirkende", "Aaron J.", "Jakob J.", "Svenja S."),
		new BackgroundPrint()
				);
	}
	
	@Override
	public void registerListeners(JFrame frame) {
		frame.addKeyListener(this);
	}

	@Override
	public void unregisterListeners(JFrame frame) {
		frame.removeKeyListener(this);
	}

	@Override
	public List<Drawable> getDrawable() {return drawables;}

	@Override
	public void drawAll(Graphics2D g) {
		for(Drawable d : drawables) {
			if(d instanceof BackgroundPrint) {
				if(((BackgroundPrint) d).print()) {
					d.draw(g);
					((BackgroundPrint) d).setPrint(false);
				}
			} else {
				
				d.draw(g);
			}
		}
		
		
		// Zeichnet den Text "(Drücken sie eine Beliebige Taste)"
		String text = "(Drücken sie eine Beliebige Taste)"; 
		g.setFont(new Font("Arial",Font.ITALIC,(int) (Main.mainFrame.getWidth() >= 1920 ? 15 : 10)));
		int x = (Main.mainFrame.getWidth() / 2) - (text.length() / 2) * (g.getFont().getSize() / 2);
		
		g.setColor(Color.white);
		g.drawString(text, (int) x, Main.mainFrame.getHeight() - (Main.mainFrame.getWidth() >= 1920 ? 15 : 10));
			
	}
	
	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			this.drawables.add(d); 
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		Main.switchPrinter(new MenuPrinter(settings));
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
