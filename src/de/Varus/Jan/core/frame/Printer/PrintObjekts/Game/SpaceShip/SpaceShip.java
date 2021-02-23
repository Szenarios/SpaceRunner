package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ShotPrint;
import de.Varus.Jan.core.managing.GameSettings;

public class SpaceShip extends SpaceShipPrint implements KeyListener {
	public ArrayList<ShotPrint> shots = new ArrayList<>(); 
	private GameSettings settings; 
	
	public SpaceShip(GameSettings settings) {
		this.settings = settings; 
	}
	
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
			System.out.println(settings.getPower());
			if(settings.getPower() >= 100)
				shots.add(new ShotPrint(this.currentPosition())); 
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
