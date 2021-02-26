package de.Varus.Jan.core.Musik;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MusikPlayer {
	/**
	 * Der Pfad zur Aido File. 
	 */
	private static final String PFAD = "Musik/"; 
	
	/**
	 * Der Audio Clip 
	 */
	private Clip clip; 
	
	/**
	 * Lädt die Audio File in unseren Clip
	 */
	public MusikPlayer() {
//		InputStream stream;
//		try {
//			stream = new FileInputStream(new File(PFAD));
//			AudioInputStream audioStream = AudioSystem.getAudioInputStream(stream);
//			
//			Clip clip = AudioSystem.getClip(); 
//			clip.open(audioStream);
//			
//			this.clip = clip; 
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (UnsupportedAudioFileException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (LineUnavailableException e) {
//			e.printStackTrace();
//		} 
	}
	
	/**
	 * Spielt unsere Audio
	 */
	public void playMusik() {
		this.clip.start();
	}
	
	/**
	 * Stop unsere Musik
	 */
	public void stopMusik() {
		this.clip.stop(); 
	}
	
	/**
	 * Gibt zurück ob der Clip läuft 
	 */
	public boolean isClipAktiv() {
		if(this.clip == null) 
			return false; 
		
		return this.clip.isActive(); 
	}
}
