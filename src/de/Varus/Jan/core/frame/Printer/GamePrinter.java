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

import de.Varus.Jan.core.DrawThread;
import de.Varus.Jan.core.HitBoxCheckingThread;
import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.Discord.RPC.DiscordGameStatus;
import de.Varus.Jan.core.frame.EndGameSence;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Listener.PowerBar;
import de.Varus.Jan.core.frame.Listener.SpaceShip;
import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.LifeBarPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ScrollingBackgroundPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ShotPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.AsteroidPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.Asteroid.RandomAsteroid.RandomAsteroidPrint;
/**
 * Der GamePrinter ist das {@link JPanel} was auf dem {@link MainFrame} durch den {@link DrawThread} gezeichnet wird und beinhaltet alle {@link Drawable} diese gezeichnet werden müssen, sowie alle Listener. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
@SuppressWarnings("serial")
public class GamePrinter extends JPanel implements IPrinter {
	/**
	 * Settings in denen Relevante Informationen für das Spiel gespeichert sind. 
	 */
	private GameSettings settings; 
	/**
	 * Die Asteroiden diese gezeichnet werden. 
	 */
	private List<AsteroidPrint> asteroidPrints = new ArrayList<AsteroidPrint>(); 
	/**
	 * Alle weiteren Drawables diese gezeichnet werden müssen.
	 */
	private List<Drawable> drawables = new ArrayList<>(); 
	
	/**
	 * Zwischengespeichertes Bild auf das alle Drawables gezeichnet werden.  
	 */
	private BufferedImage bufferedImage;
	/**
	 * Graphics vom bufferedImage 
	 */
	private Graphics2D graphics; 
	
	/**
	 * SpaceShip was gezeichnet wird sowie KeyListener um die Texturen zu verschieben. 
	 */
	private SpaceShip spaceShip; 
	/**
	 * KeyListener zur Animation von der PowerBar sowie Drawable 
	 */
	private PowerBar powerBar; 
	/**
	 * LiveBar diese werte aus settings nutzt. 
	 */
	private LifeBarPrint lifeBarPrint; 
	
	/**
	 * Interaktives Fenster zum ende des Spiels 
	 */
	private EndGameSence endGameSence; 
	/**
	 * Thread der sich beendet sobald die Leben kleiner Null fallen und das Spiel beendet. (Läuft auf 1000/60 Millisekunden)
	 */
	private HitBoxCheckingThread hitBoxCheckingThread; 
	
	/**
	 * Zeichnet sowie Steuert alle Drawables auf dem Aktuellen JFrame
	 * @see IPrinter 
	 * @see Drawable 
	 * @see HitBoxCheckingThread
	 * @param settings übergebende Spieldaten 
	 */
	public GamePrinter(GameSettings settings) { 
		this.settings = settings; 
		this.endGameSence = new EndGameSence(this.settings); 
		
		spaceShip = new SpaceShip(this.settings); 
		powerBar = new PowerBar(this.settings); 
		lifeBarPrint = new LifeBarPrint(this.settings); 

		hitBoxCheckingThread = new HitBoxCheckingThread(this.spaceShip, this.asteroidPrints, this.settings);
		
		registerDrawable(new ScrollingBackgroundPrint(), spaceShip, lifeBarPrint, powerBar);
		init();
		
		Main.discordStatus.chandeGameStatus(DiscordGameStatus.PLAYING);
	}
	
	/**
	 * überschriebende Methoden aus JPanel dadurch wird verhindert das zwischen jedem Zeichnen der Frame weiß gefärbt wird. 
	 */
	@Override
	public void update(Graphics g) {
		drawAll((Graphics2D) g);
	}

	@Override
	public void registerListeners(JFrame frame) {
		frame.addKeyListener(spaceShip);
		frame.addKeyListener(powerBar);
		frame.addMouseListener(endGameSence.getReplayButton());
	}
	@Override
	public void unregisterListeners(JFrame frame) {
		frame.removeKeyListener(spaceShip);
		frame.removeKeyListener(powerBar);
		frame.removeMouseListener(endGameSence.getReplayButton());
	}
	@Override
	public List<Drawable> getDrawable() {
		return drawables;
	}
	
	@Override
	public void drawAll(Graphics2D g) {	
		// Draws Endgame Frame 
		if(hitBoxCheckingThread.isGameOver() == true) {
			endGameSence.drawOn(g);
			return; 
		}
			
		// Hält die Asteorieden konstant auf einer anzahl
		generateAsteroids();
		
		// Zeichnet alle Drawables 
		for(Drawable d : getDrawable()) {
			d.draw(graphics);
		}
		
		// Bewegt oder Löscht die Asteorieden 
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
		
		// Zeichnet die Schüsse des Raumschiffes
		for (int i = 0; i < spaceShip.getShots().size(); i++) {
			ShotPrint s = spaceShip.getShots().get(i); 
			if (!s.isMoving() || s.isDestroyed())
				spaceShip.removeByInteger(i); 
			
			if(s.isMoving())
				s.draw(graphics);
		}
		
		// Zeichnet den Score
		drawScore(graphics);

		// Zwischen gespeichertes Image wird auf unseren Frame gezeichnet!
		g.drawImage(bufferedImage, 0, 0, null); 
		settings.setScore(settings.getScore()+ settings.getDifficulty().getPosition());
		
		Main.discordStatus.chancePoints(settings.getScore());
	}
	
	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			this.drawables.add(d); 
	}
	
	
	/* 
	 * Hält unsere Asteorieden Konstant auf einer Zahl. 
	 */
	public void generateAsteroids() { 
		if(asteroidPrints.size() <= settings.getDifficulty().getMinAsteroiden()) {
			RandomAsteroidPrint asteroid = new RandomAsteroidPrint(settings.getDifficulty());
			asteroidPrints.add(asteroid);
			registerDrawable(asteroid);
		}
		hitBoxCheckingThread.updateAsteroids(asteroidPrints);
	}
	
	/**
	 * Zeichnet auf unsere Graphics den Score
	 * @param g Das Graphic Objekt auf das gezeichnet wird. 
	 */
	public void drawScore(Graphics g) {
		graphics.setColor(Color.black);
		graphics.setFont(new Font("Arial",Font.BOLD,60));
		graphics.drawString(settings.getScore()+"", Main.mainFrame.getWidth() / 2 + 2, 56);
		
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial",Font.BOLD,60));
		graphics.drawString(settings.getScore()+"", Main.mainFrame.getWidth() / 2, 60);
		
	}
	
	/**
	 * Iniziiert das Bufferimage das zwischen gespeichert wird. 
	 */
	public void init() {
		bufferedImage = new BufferedImage(Main.mainFrame.getWidth(), Main.mainFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
	}

	/**
	 * Gibt nur die zu zeichnenden Asteroiden aus. 
	 * @return Returnt eine Liste von AsteroidenPrint Objekten. 
	 */
	public List<AsteroidPrint> getAsteroidPrints() {
		return asteroidPrints;
	}

	/**
	 * Gibt das Spaceship in unserem Aktuellen Spiel zurück. 
	 * @return Return das {@link SpaceShip}. 
	 */
	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	/**
	 * Gibt die Aktuelle Powerbar zurück. 
	 * @return {@linkplain PowerBar} mit aktuellen werten. 
	 */
	public PowerBar getPowerBar() {
		return powerBar;
	}
	
	/**
	 * Gibt das Aktuelle LifeBarPrint objekt zurück. 
	 * @return {@linkplain LifeBarPrint} mit Aktuellem Leben. 
	 */
	public LifeBarPrint getLifeBarPrint() {
		return lifeBarPrint;
	}
}