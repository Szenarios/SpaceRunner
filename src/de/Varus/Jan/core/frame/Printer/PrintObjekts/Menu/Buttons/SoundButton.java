package de.Varus.Jan.core.frame.Printer.PrintObjekts.Menu.Buttons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	 * Das Image wenn der Sound an ist. 
	 */
	private Image soundON; 
	/**
	 * Das Image wenn der Sound aus ist. 
	 */
	private Image soundOff; 

	/**
	 * Erzeugt einen {@link ButtonPrint} und änder je nach Status der Musik die Grafik. 
	 * @param numberDesButons Die Anzahl des Buttons.
	 */
	public SoundButton(int numberDesButons) {
		super(getPfad(Main.musikPlayer.isClipAktiv()), new SoundButtonRunnable(), numberDesButons);
		try {
			this.soundOff = ImageIO.read(new File(getPfad(false)));
			this.soundON = ImageIO.read(new File(getPfad(true)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(Main.musikPlayer.isClipAktiv() ? soundON : soundOff, this.x(), this.y(), this.width(), this.height, null); 
	}
	
	/**
	 * Gibt den entsprechenden Pfad für den entsprechenden Musik Status. 
	 * @param playing ob der Sound an ist oder nicht. 
	 * @return Der Pfad der Texture 
	 */
	private static String getPfad(boolean playing) {
		if(playing)
			return "Grafiks/SoundButtonOn.png"; 
		else 
			return "Grafiks/SoundButtonOff.png"; 
	}

}
