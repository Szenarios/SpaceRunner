package de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.SpaceShip;

public enum SpaceShipState {
	GERADE(400), LEICHT_LINKS(200), LEICHT_RECHTS(600), STARK_LINKS(0), STARK_RECHTS(800); 

	private int x; 
	SpaceShipState(int x) {
		this.x = x; 
	}
	public int get() {
		return x; 
	}
}
