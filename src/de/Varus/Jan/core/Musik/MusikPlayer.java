package de.Varus.Jan.core.Musik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import de.Varus.Jan.core.frame.GameSettings;

/**
 * Lädt einen bestimmten Track und kann diesen Abspielen und wieder Starten. 
 * @author Szenarios
 * @version F1.03.21
 *
 */
public class MusikPlayer {
	
	/**
	 * Die Aktuellen {@link GameSettings}
	 */
	private GameSettings settings; 
	
	/**
	 * Der Pfad zur Aido File. 
	 */
	private static final String PFAD = "Musik/GameMusik.wav"; 
	
	/**
	 * Der Audio Clip 
	 */
	private Clip clip; 
	
	/**
	 * Lädt die Audio File in unseren Clip
	 * @param settings Die Aktuellen {@link GameSettings}
	 */
	public MusikPlayer(GameSettings settings) {
		this.settings = settings; 
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(PFAD));
			
			Clip clip = AudioSystem.getClip(); 
			this.clip = clip; 
			clip.open(audioStream);
//			clip.setLoopPoints(0, (int) audioStream.getFrameLength());
			playMusik();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Spielt unsere Audio
	 */
	public void playMusik() {
		this.clip.start();
		this.settings.setPlaying(true);
	}
	
	/**
	 * Stop unsere Musik
	 */
	public void stopMusik() {
		this.clip.stop(); 
		this.settings.setPlaying(false);
	}
	
	/**
	 * Gibt zurück ob der Clip läuft 
	 * @return True wenn Clip Aktiv ist. False wenn dieser null oder inaktiv ist. 
	 */
	public boolean isClipAktiv() {
		return settings.isPlaying();
	}
	
	/**
	 * Spielt den Gameover Sound. 
	 */
	public void playGameOverSound() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("Musik/DeadSound.wav"));
			
			Clip clip = AudioSystem.getClip(); 
			clip.open(audioStream);
			
			boolean oldStatus = settings.isPlaying(); 
			
			stopMusik();
			
			
			this.settings.setPlaying(oldStatus);
			clip.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} 
	}
}
