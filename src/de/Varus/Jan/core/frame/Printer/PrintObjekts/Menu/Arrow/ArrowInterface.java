package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Arrow;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.Difficulty;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Difficulty.DifficultyPrint;
/**
 * Das Interface wird f�r die {@link Difficulty} einstellung genutzt um bei einem (Egal welche Richtung) click der Richtigen Button getriggert wird.
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public interface ArrowInterface {
	/**
	 * Wird ausgef�hrt wenn ein Pfeil in eine Richtung gedr�ckt wurde. 
	 * @param rotation Gibt die Richtung an in die der Pfeil zeigt. 
	 * @param print Die Difficulty anzeige die durch den Click ver�ndern werden k�nnte. 
	 */
	public void arrowClick(ArrowRotation rotation, DifficultyPrint print); 
}
