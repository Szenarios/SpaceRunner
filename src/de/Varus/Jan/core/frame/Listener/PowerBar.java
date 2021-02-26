package de.Varus.Jan.core.frame.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBar.PowerBarPrint;

/**
 * Ist der KeyListener zu {@link PowerBarPrint} und bearbeitet diesen bei Knopfclicks. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class PowerBar extends PowerBarPrint implements KeyListener {
	/**
	 * Die {@link GameSettings} die je nach Knopf druck bearbeitet werden. 
	 */
	private GameSettings settings; 
	/**
	 * Reagiert auf die Leertatste und setze unseren Power wert in den {@link GameSettings} auf 0; 
	 * @see PowerBarPrint
	 * @see KeyListener
	 * @param settings Die {@link GameSettings} die den Power Wert Speichern. 
	 */
	public PowerBar(GameSettings settings) {
		super(settings);
		this.settings = settings; 
	} 
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(this.power >= 100) {
				this.power = 0; 
				settings.setPower((int) this.power);
				System.out.println("Piu...");
			}		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
