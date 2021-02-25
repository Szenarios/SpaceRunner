package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.DifficultyPrint;

public interface ArrowInterface {
	/**
	 * Wird ausgeführt wenn ein Pfeil in eine Richtung gedrückt wurde. 
	 * @param rotation Gibt die Richtung an in die der Pfeil zeigt. 
	 * @param print Die Difficulty anzeige die durch den Click verändern werden kännte. 
	 */
	public void arrowClick(ArrowRotation rotation, DifficultyPrint print); 
}
