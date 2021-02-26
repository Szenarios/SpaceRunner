package de.Varus.Jan.core.frame.Printer.PrintObjekts.Story;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.GamePrinter;
import de.Varus.Jan.core.frame.Printer.IPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Moveable;
/**
 * Zeichnet den Story Text auf den Bildschirm in einer Animation. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
@SuppressWarnings("serial")
public class StoryPrinter extends JPanel implements IPrinter, KeyListener {
	/**
	 * Die {@link Drawable} die gezeichnet werden. 
	 */
	private ArrayList<Drawable> drawables = new ArrayList<>(); 
	/**
	 * Der Pfad für den Text der Story
	 */
	private final String PFAD = "Story/Story.txt"; 
	/**
	 * Die Aktuellen {@link GameSettings}
	 */
	private GameSettings settings; 
	
	/**
	 * Zeichnet den geladenen Text auf den {@link MainFrame}
	 * @param settings Die Aktuellen {@link GameSettings}
	 */
	
	/**
	 * Zwischengespeichertes Bild auf das alle Drawables gezeichnet werden.  
	 */
	private BufferedImage bufferedImage;
	/**
	 * Graphics vom bufferedImage 
	 */
	private Graphics2D graphics; 
	
	/**
	 * Zeichnet die einen Animierten Text auf den {@link MainFrame}
	 * @param settings Die Aktuellen {@link GameSettings}
	 */
	public StoryPrinter(GameSettings settings) {
		ArrayList<String> text = new ArrayList<String>(); 
		Scanner scanner;
		try {
			scanner = new Scanner(new File(PFAD));
			while(scanner.hasNext()) {
				text.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		registerDrawable(new TextPrint(text));
		this.settings = settings; 
		settings.setStoryShown(true);
		
		init();
	} 
	
	@Override
	public void update(Graphics g) {
		drawAll((Graphics2D) g);
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
	public List<Drawable> getDrawable() {
		return drawables;
	}

	@Override
	public void drawAll(Graphics2D g) {
		for(Drawable d : getDrawable())
			if(d instanceof TextPrint) 
				if(!((TextPrint) d).isMoving()) 
					Main.switchPrinter(new GamePrinter(settings));
				
		this.graphics.setColor(Color.black);
		this.graphics.fillRect(0, 0, Main.mainFrame.getWidth(), Main.mainFrame.getHeight());
		
		for(Drawable d : getDrawable())
			if(d instanceof Moveable) 
				((Moveable) d).move();
		
		for(Drawable d : drawables)
			d.draw(this.graphics);
		
		g.drawImage(bufferedImage, 0, 0, null); 
	}

	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			drawables.add(d); 
	}
	
	/**
	 * Iniziiert das Bufferimage das zwischen gespeichert wird. 
	 */
	public void init() {
		bufferedImage = new BufferedImage(Main.mainFrame.getWidth(), Main.mainFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		Main.switchPrinter(new GamePrinter(settings)); // Die Story wird geskipped
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
