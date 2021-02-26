package de.Varus.Jan.core.Runnables.Buttons;

import de.Varus.Jan.core.Main;

/**
 * Reagiert auf anclicken und beendet das Spie. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class CloseButtonRunnable implements Runnable{

	@Override
	public void run() {
		Main.musikPlayer.stopMusik();
		System.exit(0);
	}

}
