package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.Discord.RPC.DiscordGameStatus;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Listener.PrinterMouse;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Background;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.BSettingsPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.BackgroundPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.PlayButtonPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow.ArrowPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow.ArrowRotation;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.DifficultyPrint;

public class MenuPrinter extends JPanel implements IPrinter {
	private List<Drawable> drawables = new ArrayList<>(); 
	private PrinterMouse listener; 
	private GameSettings settings = new GameSettings(Difficulty.NORMAL); 
	
	public MenuPrinter() {
		listener = new PrinterMouse(this); 
		
		registerDrawable(new BackgroundPrint(), new BSettingsPrint(), new DifficultyPrint(this), new ArrowPrint(ArrowRotation.ARROWLEFT, this), new ArrowPrint(ArrowRotation.ARROWRIGHT, this), new PlayButtonPrint(settings));
		
		Main.discordStatus.chandeGameStatus(DiscordGameStatus.MENU);
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
					d.draw(g);
				}
			} else {
				d.draw(g);
			}
		}
	}
	@Override
	public void registerDrawable(Drawable... drawable) {
		for(Drawable d : drawable)
			this.drawables.add(d); 
	}
	
	public Difficulty getDifficulty() {
		return settings.getDifficulty(); 
	}
	public void setDifficulty(Difficulty difficulty) { 
		this.settings.setDifficulty(difficulty);
	}
	
}
