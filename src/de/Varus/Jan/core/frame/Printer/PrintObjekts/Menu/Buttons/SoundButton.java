package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.Runnables.Buttons.SoundButtonRunnable;
/**
 * Ein Spezieller {@link ButtonPrint} der die Musik aus und ein schalten kann. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class SoundButton extends ButtonPrint {

	/**
	 * Erzeugt einen {@link ButtonPrint} und änder je nach Status der Musik die Grafik. 
	 * @param numberDesButons Die Anzahl des Buttons.
	 */
	public SoundButton(int numberDesButons) {
		super(getPfad(), new SoundButtonRunnable(), numberDesButons);
	
	}
	
	/**
	 * Gibt den entsprechenden Pfad für die entsprechenden Musik Status an. 
	 * @return Der Pfad der Texture 
	 */
	private static String getPfad() {
		if(Main.musikPlayer.isClipAktiv())
			return "Grafiks/SoundButtonOn.png"; 
		else 
			return "Grafiks/SoundButtonOff.png"; 
	}

}
