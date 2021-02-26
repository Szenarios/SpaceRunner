package de.Varus.Jan.core.Runnables.Buttons;

import de.Varus.Jan.core.Main;

public class SoundButtonRunnable implements Runnable {

	@Override
	public void run() {
		if(Main.musikPlayer.isClipAktiv())
			Main.musikPlayer.stopMusik();
		else 
			Main.musikPlayer.stopMusik();
	}

}
