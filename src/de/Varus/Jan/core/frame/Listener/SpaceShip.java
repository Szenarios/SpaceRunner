package de.Varus.Jan.core.frame.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.ShotPrint;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.Direction;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.SpaceShipPrint;

public class SpaceShip extends SpaceShipPrint implements KeyListener {
	/**
	 * Die Schüsse {@link ShotPrint} in einer Liste  
	 */
	private ArrayList<ShotPrint> shots = new ArrayList<>(); 
	/**
	 * Die {@link GameSettings} des Aktuellen Spiels. 
	 */
	private GameSettings settings; 
	
	/**
	 * Reagiert auf die Tasten D und A und verändert die Kordinaten von {@link SpaceShipPrint} dementsprechend. 
	 * @see SpaceShipPrint
	 * @see KeyListener
	 * @param settings
	 */
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

	/**
	 * Gibt die Aktuellen schüsse wieder. 
	 * @return Alle {@link Shotprint} die Aktiv sind in einer Liste. 
	 */
	public ArrayList<ShotPrint> getShots() {
		return shots;
	}
	
	/**
	 * Lösch einen {@link ShotPrint} aus der Liste
	 * @param key Position als {@link Integer} von dem {@link ShotPrint} in der Liste.
	 */
	public void removeByInteger(int key) {
		shots.remove(key); 
	}
	
	
}
