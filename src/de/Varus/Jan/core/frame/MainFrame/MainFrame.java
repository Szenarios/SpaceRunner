package de.Varus.Jan.core.frame.MainFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Der Hauptframe auf dem alles gezeichnet wird. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	/**
	 * Der Aktuelle ScreenMode des Hauptfensters. 
	 */
	private ScreenMode screenMode;
	
	/**
	 * Unser Mainframe (�ffnet auf Voller Screen Aufl�sung)
	 * @see JFrame 
	 */
	public MainFrame() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(d);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		screenMode = ScreenMode.FULLSCREEN; 
	}
	/**
	 * Gibt den Aktuellen ScreenMode zur�ck. 
	 * @return Gibt den Aktuellen {@linkplain ScreenMode} zur�ck. 
	 */
	public ScreenMode getScreenMode() {
		return screenMode;
	}

	/**
	 * Setzt den Aktuellen {@link ScreenMode}. 
	 * @param screenMode �ndern den Aktuellen {@link ScreenMode} zu dem Angegeben. 
	 */
	public void setScreenMode(ScreenMode screenMode) {
		this.screenMode = screenMode;
	}

	
}
