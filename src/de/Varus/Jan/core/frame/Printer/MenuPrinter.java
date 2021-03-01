package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.DrawThread;
import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.Discord.RPC.DiscordGameStatus;
import de.Varus.Jan.core.Runnables.Buttons.CloseButtonRunnable;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Listener.PrinterMouse;
import de.Varus.Jan.core.frame.MainFrame.MainFrame;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Background;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.BackgroundPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.LogoPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow.ArrowPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow.ArrowRotation;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons.ButtonPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons.CreditButtonPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons.PlayButtonPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons.SoundButton;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.DifficultyPrint;
/**
 * Der {@link MenuPrinter} ist das {@link JPanel} was auf den {@link MainFrame} mit dem {@link DrawThread} gezeichnet wird. Es beinhaltet alle {@link Drawable} und Listener die gebraucht werden. Und erstellt für das kommende Spiel die benötigten {@link GameSettings}. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
@SuppressWarnings("serial")
public class MenuPrinter extends JPanel implements IPrinter {
	/**
	 * Alle weiteren Drawables diese gezeichnet werden müssen.
	 */
	private List<Drawable> drawables = new ArrayList<>(); 
	/**
	 * Der Mouselistner der die Clicks an die Clickable weiter leitet. 
	 */
	private PrinterMouse listener; 
	/**
	 * Die {@link GameSettings} womit das Game gestartet wird. 
	 */
	private GameSettings settings; 
	/**
	 * Zwischengespeichertes Bild auf das alle Drawables gezeichnet werden.  
	 */
	private BufferedImage bufferedImage;
	/**
	 * Graphics vom bufferedImage 
	 */
	private Graphics2D graphics; 
	
	/**
	 * Zeichnet alle Drawables auf dem {@link MainFrame}.
	 * @param settings Die Aktuellen {@link GameSettings} 
	 */
	public MenuPrinter(GameSettings settings) {
		this.settings = settings; 
		listener = new PrinterMouse(this); 
		
		registerDrawable(new BackgroundPrint(), new ButtonPrint("Grafiks/CloseButton.png", new CloseButtonRunnable(), 1), new CreditButtonPrint(3, settings), new SoundButton(2), new DifficultyPrint(this), new ArrowPrint(ArrowRotation.ARROWLEFT, this), new ArrowPrint(ArrowRotation.ARROWRIGHT, this), new PlayButtonPrint(settings), new LogoPrint());
		
		Main.discordStatus.chandeGameStatus(DiscordGameStatus.MENU);
		
		init();
		
		
		if(settings.isPlaying())
			Main.musikPlayer.playMusik();
	}	
	
	@Override
	public void registerListeners(JFrame frame) {
		frame.addMouseListener(listener);
	}
	@Override
	public void unregisterListeners(JFrame frame) {
		frame.removeMouseListener(listener);
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
					d.draw(graphics);
				}
			} else {
				d.draw(graphics);
			}
		}
		
		g.drawImage(bufferedImage, 0, 0, null); 
	}
	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			this.drawables.add(d); 
	}
	
	/**
	 * Gibt den Aktuellen {@link Difficulty} zurück.
	 * @return Der Aktuelle {@link Difficulty}
	 */
	public Difficulty getDifficulty() {
		return settings.getDifficulty(); 
	}
	/**
	 * Setze den Aktuellen {@link Difficulty}. 
	 * @param difficulty Der Neue Aktuelle {@link Difficulty}. 
	 */
	public void setDifficulty(Difficulty difficulty) { 
		this.settings.setDifficulty(difficulty);
	}
	/**
	 * Iniziiert das Bufferimage das zwischen gespeichert wird. 
	 */
	public void init() {
		bufferedImage = new BufferedImage(Main.mainFrame.getWidth(), Main.mainFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
	}
}
