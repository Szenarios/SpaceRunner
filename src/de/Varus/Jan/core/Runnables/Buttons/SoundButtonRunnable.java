package de.Varus.Jan.core.Runnables.Buttons;

import de.Varus.Jan.core.Main;
/**
 * Fängt an Musik abzuspielen oder beendet diese. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class SoundButtonRunnable implements Runnable {

	@Override
	public void run() {
		if(Main.musikPlayer.isClipAktiv())
			Main.musikPlayer.stopMusik();
		else 
			Main.musikPlayer.playMusik();
	}

}
