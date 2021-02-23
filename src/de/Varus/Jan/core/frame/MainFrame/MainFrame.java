package de.Varus.Jan.core.frame.MainFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	private ScreenMode screenMode;
	public MainFrame() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(d);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		screenMode = ScreenMode.FULLSCREEN; 
	}
	public ScreenMode getScreenMode() {
		return screenMode;
	}

	public void setScreenMode(ScreenMode screenMode) {
		this.screenMode = screenMode;
	}

	
}
