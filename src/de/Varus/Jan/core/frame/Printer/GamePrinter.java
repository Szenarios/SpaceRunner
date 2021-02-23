package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Background;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.LifeBarPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ScrollingBackgroundPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid.RandomAsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBar.PowerBar;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.SpaceShip;
import de.Varus.Jan.core.managing.GameSettings;

public class GamePrinter extends JPanel implements IPrinter {
	private List<AsteroidPrint> asteroidPrints = new ArrayList<AsteroidPrint>(); 
	private List<Drawable> drawables = new ArrayList<>(); 
	private GameSettings settings; 
	
	private BufferedImage bufferedImage; 
	private Graphics2D graphics; 
	
	private SpaceShip spaceShip; 
	private PowerBar powerBar; 
	private LifeBarPrint lifeBarPrint; 
	
	public GamePrinter(GameSettings settings) { 
		this.settings = settings; 
		spaceShip = new SpaceShip(); 
		powerBar = new PowerBar(); 
		lifeBarPrint = new LifeBarPrint(); 
		
		registerDrawable(new ScrollingBackgroundPrint(), spaceShip, lifeBarPrint, powerBar);
		init();
	}
	@Override
	public void update(Graphics g) {
		drawAll((Graphics2D) g);
	}
	
	@Override
	public void registerListeners(JFrame frame) {
		frame.addKeyListener(spaceShip);
		frame.addKeyListener(powerBar);
	}
	@Override
	public void unregisterListeners(JFrame frame) {
		frame.removeKeyListener(spaceShip);
		frame.removeKeyListener(powerBar);
	}
	@Override
	public List<Drawable> getDrawable() {
		return drawables;
	}

	@Override
	public void drawAll(Graphics2D g) {	
		drawBackground(graphics);
		generateAsteroids();
		g.setPaintMode();
		for(Drawable d : getDrawable()) {
			if(!(d instanceof Background)) {
				d.draw(graphics);
			} 
		}
		
		for (int i = 0; i < asteroidPrints.size(); i++) {
			AsteroidPrint a = asteroidPrints.get(i); 
			if (!a.isMoving()) {
				this.drawables.remove(a);
				this.asteroidPrints.remove(((AsteroidPrint) a));
			} else {
				a.move();
			}
		}
		g.drawImage(bufferedImage, 0, 0, null); 
	}
	public void drawBackground(Graphics g) {
		for(Drawable d : getDrawable()) 
			if(d instanceof Background) 
				if(((Background) d).print()) 
					d.draw((Graphics2D) g);
	}
	
	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			this.drawables.add(d); 
	}
	
	public void generateAsteroids() { 
		if(asteroidPrints.size() <= settings.getDifficulty().getMinAsteroiden()) {
			RandomAsteroidPrint asteroid = new RandomAsteroidPrint(settings.getDifficulty());
			System.out.println(asteroid.toString());
			asteroidPrints.add(asteroid);
			registerDrawable(asteroid);
		}
	}
	
	public void init() {
		bufferedImage = new BufferedImage(Main.mainFrame.getWidth(), Main.mainFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
	}
	

}
