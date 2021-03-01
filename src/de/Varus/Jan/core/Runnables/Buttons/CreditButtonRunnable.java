package de.Varus.Jan.core.Runnables.Buttons;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.CreditPrinter;

public class CreditButtonRunnable implements Runnable {
	/**
	 * Die Aktuellen {@link GameSettings}
	 */
	private GameSettings settings; 
	/**
	 * Changet den Aktiven Printer auf {@link CreditPrinter}
	 * @param settings
	 */
	public CreditButtonRunnable(GameSettings settings) {
		this.settings = settings; 
	}

	@Override
	public void run() {
		Main.switchPrinter(new CreditPrinter(settings)); 
	}
}
