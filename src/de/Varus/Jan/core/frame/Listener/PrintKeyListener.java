package de.Varus.Jan.core.frame.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.Direction;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip.SpaceShipPrint;

public class PrintKeyListener implements KeyListener {
	private SpaceShipPrint spaceShipPrint; 
	private int lastKey = 0; 
	public PrintKeyListener(SpaceShipPrint spaceShipPrint) {
		this.spaceShipPrint = spaceShipPrint; 
	}
	@Override
	public void keyTyped(KeyEvent e) {
//		int key = e.getKeyCode();
//		
//		if(lastKey != 0) {
//			if(lastKey == e.getKeyCode()) {
//				if(key == KeyEvent.VK_D) {
//					spaceShipPrint.superMove(Direction.RIGHT);
//				} else 
//				if(key == KeyEvent.VK_A) {
//					spaceShipPrint.superMove(Direction.LEFT);
//				}
//			}
//		
//		} 
//		lastKey = key; 
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); 
		if(key == KeyEvent.VK_D) {
			spaceShipPrint.startMove(Direction.RIGHT);
		} else 
		if(key == KeyEvent.VK_A) {
			spaceShipPrint.startMove(Direction.LEFT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode(); 
		if(key == KeyEvent.VK_D) {
			spaceShipPrint.endMove(Direction.RIGHT);
		} else 
		if(key == KeyEvent.VK_A) {
			spaceShipPrint.endMove(Direction.LEFT);
		}
	}

}
