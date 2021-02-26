package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.DifficultyPrint;
/**
 * Das Interface wird für die {@link Difficulty} einszellung genutzt um bei einem (Egal welche Richtung) click der Richtige Button getriggert wird.
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public interface ArrowInterface {
	/**
	 * Wird ausgeführt wenn ein Pfeil in eine Richtung gedrückt wurde. 
	 * @param rotation Gibt die Richtung an in die der Pfeil zeigt. 
	 * @param print Die Difficulty anzeige die durch den Click verändern werden kännte. 
	 */
	public void arrowClick(ArrowRotation rotation, DifficultyPrint print); 
}
