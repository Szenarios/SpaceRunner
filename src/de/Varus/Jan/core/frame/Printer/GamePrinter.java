package de.Varus.Jan.core.frame.Printer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.HitBoxCheckingThread;
import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.LifeBarPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ScrollingBackgroundPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ShotPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid.RandomAsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBar.PowerBar;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.SpaceShip;
import de.Varus.Jan.core.managing.GameSettings;

public class GamePrinter extends JPanel implements IPrinter {
	private GameSettings settings; 
	private List<AsteroidPrint> asteroidPrints = new ArrayList<AsteroidPrint>(); 
	private List<Drawable> drawables = new ArrayList<>(); 
	
	private BufferedImage bufferedImage; 
	private Graphics2D graphics; 
	
	private SpaceShip spaceShip; 
	private PowerBar powerBar; 
	private LifeBarPrint lifeBarPrint; 
	
	private HitBoxCheckingThread hitBoxCheckingThread; 
	public GamePrinter(GameSettings settings) { 
		this.settings = settings; 
		
		spaceShip = new SpaceShip(this.settings); 
		powerBar = new PowerBar(this.settings); 
		lifeBarPrint = new LifeBarPrint(this.settings); 

		hitBoxCheckingThread = new HitBoxCheckingThread(this.spaceShip, this.asteroidPrints, this.settings);
		
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
		if(hitBoxCheckingThread.isGameOver() == true)
			return; 
		
		generateAsteroids();
		
		for(Drawable d : getDrawable()) {
			d.draw(graphics);
		}
		
		for (int i = 0; i < asteroidPrints.size(); i++) {
			AsteroidPrint a = asteroidPrints.get(i); 
			if (!a.isMoving()) {
				this.drawables.remove(a);
				this.asteroidPrints.remove(((AsteroidPrint) a));
				settings.setScore(settings.getScore()+1);
			} else {
				a.move();
			}
		}
		
		for (int i = 0; i < spaceShip.getShots().size(); i++) {
			ShotPrint s = spaceShip.getShots().get(i); 
			if (!s.isMoving() || s.isDestroyed())
				spaceShip.removeByInteger(i); 
			
			if(s.isMoving())
				s.draw(graphics);
		}
		
		drawScore(graphics);

		g.drawImage(bufferedImage, 0, 0, null); 
		settings.setScore(settings.getScore()+1);
	}
	
	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			this.drawables.add(d); 
	}
	
	public void generateAsteroids() { 
		if(asteroidPrints.size() <= settings.getDifficulty().getMinAsteroiden()) {
			RandomAsteroidPrint asteroid = new RandomAsteroidPrint(settings.getDifficulty());
			asteroidPrints.add(asteroid);
			registerDrawable(asteroid);
		}
		hitBoxCheckingThread.updateAsteroids(asteroidPrints);
	}
	
	public void drawScore(Graphics g) {
		graphics.setColor(Color.black);
		graphics.setFont(new Font("Arial",Font.BOLD,60));
		graphics.drawString(settings.getScore()+"", Main.mainFrame.getWidth() / 2 + 2, 56);
		
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial",Font.BOLD,60));
		graphics.drawString(settings.getScore()+"", Main.mainFrame.getWidth() / 2, 60);
		
	}
	
	public void init() {
		bufferedImage = new BufferedImage(Main.mainFrame.getWidth(), Main.mainFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
	}

	public List<AsteroidPrint> getAsteroidPrints() {
		return asteroidPrints;
	}

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	public PowerBar getPowerBar() {
		return powerBar;
	}

	public LifeBarPrint getLifeBarPrint() {
		return lifeBarPrint;
	}

}
