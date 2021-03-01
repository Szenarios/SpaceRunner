package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons;

import de.Varus.Jan.core.Runnables.Buttons.CreditButtonRunnable;
import de.Varus.Jan.core.frame.GameSettings;
/**
 * Der Button für die Credits. 
 * @author Szenarios
 * @version F1.03.21
 *
 */
public class CreditButtonPrint extends ButtonPrint {
	/**
	 * Ergzeugt einen CreditButton 
	 * @param numberDesButons Die Button Nummer 
	 * @param settings Die Aktuellen {@link GameSettings}
	 */
	public CreditButtonPrint(int numberDesButons, GameSettings settings) {
		super("Grafiks/CreditButton.png", new CreditButtonRunnable(settings), numberDesButons);
	}


}
