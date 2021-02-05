package de.Varus.Jan.core.frame.Printer;

import java.awt.Graphics2D;
import java.util.List;

import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public interface IPrinter {
	void registerListeners();
	List<Drawable> getDrawable(); 
	void drawAll(Graphics2D g); 
}
