package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceShip extends SpaceShipPrint implements KeyListener {
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_D:
			this.startMove(Direction.RIGHT);
			break;
		case KeyEvent.VK_A:
			this.startMove(Direction.LEFT);
			break;
			
		case KeyEvent.VK_SPACE: 
			System.err.println("Shot");
			break; 
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_D:
			this.endMove(Direction.RIGHT);
			break;
		case KeyEvent.VK_A:
			this.endMove(Direction.LEFT);
			break;
		default:
			break;
		}
	}
}
