package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JFrame;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public interface IPrinter {
	void registerListeners(JFrame frame);
	void unregisterListeners(JFrame frame);
	List<Drawable> getDrawable(); 
	void drawAll(Graphics2D g); 
	void registerDrawable(Drawable... drawable); 
}
