package de.Varus.Jan.core.frame.MainFrame;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private ScreenMode screenMode;
	public MainFrame() {
		// TODO Size 
		this.setSize(100, 199);// test
		this.setVisible(true);
	}
	public ScreenMode getScreenMode() {
		return screenMode;
	}

	public void setScreenMode(ScreenMode screenMode) {
		this.screenMode = screenMode;
	}

	
}
