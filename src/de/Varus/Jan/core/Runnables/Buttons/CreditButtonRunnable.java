package de.Varus.Jan.core.Runnables.Buttons;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.CreditPrinter;
/**
 * Erzeugt den Credit Button RUnnable der den Credit Printer aufruft. 
 * @author Szenarios
 * @version F1.03.21
 */
public class CreditButtonRunnable implements Runnable {
	/**
	 * Die Aktuellen {@link GameSettings}
	 */
	private GameSettings settings; 
	/**
	 * Changet den Aktiven Printer auf {@link CreditPrinter}
	 * @param settings Die Aktuellen {@link GameSettings}
	 */
	public CreditButtonRunnable(GameSettings settings) {
		this.settings = settings; 
	}

	@Override
	public void run() {
		Main.switchPrinter(new CreditPrinter(settings)); 
	}
}
