package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.PowerBar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.Varus.Jan.core.managing.GameSettings;


public class PowerBar extends PowerBarPrint implements KeyListener {
	private GameSettings settings; 
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
